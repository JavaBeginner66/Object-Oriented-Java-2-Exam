package Controller.SpillerappController;

import Model.AdmappModel.FinalChessObject;
import Model.AdmappModel.MatchResult;
import Model.SpillerappModel.Interface.GameEngine;
import Model.SpillerappModel.Points;
import View.AdmappView.RegisterMovePanel;
import View.SpillerappView.MainFrame;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;

public class DisplayPanelController implements EventHandler<ActionEvent> {

    private MainFrame mainFrame;
    private GameEngine gameEngine;

    public final static File points = new File("poeng");

    private ObjectInputStream fromFile;
    private ObjectOutputStream toFile;
    private ObjectInputStream fromPointsFile;
    private ObjectOutputStream toPointsFile;
    private ObjectInputStream fromMatchFile;


    public DisplayPanelController(MainFrame mainFrame, GameEngine gameEngine){
        this.mainFrame = mainFrame;
        this.gameEngine = gameEngine;
    }


    @Override
    public void handle(ActionEvent event) {
        Button b = (Button) event.getSource();
        String s = b.getText();
        switch(s){
            case "Rangering":
                listRanks();
                break;
            case "Søk etter person":
                listMatches();
                break;
        }
    }



    private void listRanks(){

        VBox ranksWindow = new VBox();
        Scene rankScene = new Scene(ranksWindow, 300, 500);

        Stage newWindow = new Stage();
        newWindow.setTitle("Rangering");
        newWindow.setScene(rankScene);

        writeRanksFromFile(ranksWindow);

        newWindow.show();
    }

    private void writeRanksFromFile(VBox window){
        if(RegisterMovePanel.matchOverview.exists() && points.exists()) {
            try {
                FileInputStream f = new FileInputStream(RegisterMovePanel.matchOverview);

                try {
                    FinalChessObject chessObject;

                    for (; ; ) {

                        fromFile = new ObjectInputStream(f);

                        chessObject = (FinalChessObject) fromFile.readObject();

                        Points name1 = new Points(chessObject.getMatchResult().getMatchInfo().getName1());
                        Points name2 = new Points(chessObject.getMatchResult().getMatchInfo().getName2());

                        switch (chessObject.getMatchResult().getResult()) {
                            case "1-0":
                                name1.addPoints(1);
                                break;
                            case "0-1":
                                name2.addPoints(1);
                                break;
                            case "1/2-1/2":
                                name1.addPoints(0.5);
                                name2.addPoints(0.5);
                                break;
                        }

                        try{
                            FileOutputStream o = new FileOutputStream(points);

                            toPointsFile = new ObjectOutputStream(o);
                            toPointsFile.writeObject(name1);
                            toPointsFile.writeObject(name2);

                        }catch (IOException ioe){
                            ioe.printStackTrace();
                        }

                        try{
                            FileInputStream s = new FileInputStream(points);
                            try{
                                Points points;
                                fromPointsFile = new ObjectInputStream(s);
                                for(;;){
                                    points = (Points)fromPointsFile.readObject();
                                    window.getChildren().addAll(new Label(points.toString()));
                                }
                            }catch (EOFException eof){
                                s.close();
                            }
                        }catch (IOException io){
                            io.printStackTrace();
                        }
                    }
                }catch (ClassNotFoundException cl){
                    cl.printStackTrace();
                }catch (EOFException eof) {
                    f.close();
                }
            } catch (IOException io) {
                io.printStackTrace();
            }
        }else{
            try {
                toFile = new ObjectOutputStream(new FileOutputStream(RegisterMovePanel.matchOverview, true));
                toPointsFile = new ObjectOutputStream(new FileOutputStream(points, true));
                toFile.close();
                toPointsFile.close();
                writeRanksFromFile(window);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }





    private void listMatches(){
        String name = mainFrame.getDisplayPanel().getSearchArea().getText();

        if(RegisterMovePanel.matchOverview.exists()) {
            try {
                FileInputStream f = new FileInputStream(RegisterMovePanel.matchOverview);
                try {
                    FinalChessObject chessObject;
                    mainFrame.getDisplayPanel().getMatches().getItems().clear();
                    for (; ;) {
                        fromMatchFile = new ObjectInputStream(f);
                        chessObject = (FinalChessObject) fromMatchFile.readObject();
                        if(name.equals(chessObject.getMatchResult().getMatchInfo().getName1()) ||
                            name.equals(chessObject.getMatchResult().getMatchInfo().getName2())){
                            mainFrame.getDisplayPanel().getMatches().getItems().addAll(chessObject);
                        }
                    }
                }catch (ClassNotFoundException c){
                    c.printStackTrace();
                }catch (EOFException eof) {
                    f.close();
                }
            } catch (IOException io) {
                io.printStackTrace();
            }
        }else{
            try {
                toFile = new ObjectOutputStream(new FileOutputStream(RegisterMovePanel.matchOverview, true));
                /*
                toPointsFile = new ObjectOutputStream(new FileOutputStream(points, true));
                toPointsFile.close();
                toFile.close();
                */
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package Controller.SpillerappController;

import Model.AdmappModel.FinalChessObject;
import Model.AdmappModel.MatchResult;
import Model.SpillerappModel.Interface.GameEngine;
import View.AdmappView.RegisterMovePanel;
import View.SpillerappView.MainFrame;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;

public class DisplayPanelController implements EventHandler<ActionEvent> {

    private MainFrame mainFrame;
    private GameEngine gameEngine;

    public DisplayPanelController(MainFrame mainFrame, GameEngine gameEngine){
        this.mainFrame = mainFrame;
        this.gameEngine = gameEngine;
    }


    @Override
    public void handle(ActionEvent event) {
        Button b = (Button) event.getSource();
        String s = b.getText();
        switch(s){
            case "Rankering":
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
        newWindow.setTitle("Rangeringer");
        newWindow.setScene(rankScene);

        //writeRanksFromFile(ranksWindow);

        newWindow.show();
    }

    private void writeRanksFromFile(VBox window){
        if(RegisterMovePanel.matchOverview.exists()) {
            try {
                FileInputStream f = new FileInputStream(RegisterMovePanel.matchOverview);
                try {
                    FinalChessObject chessObject;
                    for (; ;) {
                        ObjectInputStream fromFile = new ObjectInputStream(f);
                        chessObject = (FinalChessObject) fromFile.readObject();
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
                ObjectOutputStream createNewFile = new ObjectOutputStream(new FileOutputStream(RegisterMovePanel.matchOverview, true));
                createNewFile.close();
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

                        ObjectInputStream fromFile = new ObjectInputStream(f);
                        chessObject = (FinalChessObject) fromFile.readObject();
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
                ObjectOutputStream createNewFile = new ObjectOutputStream(new FileOutputStream(RegisterMovePanel.matchOverview, true));
                createNewFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

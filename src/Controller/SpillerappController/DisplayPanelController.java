package Controller.SpillerappController;

import Model.AdmappModel.FinalChessObject;
import Model.AdmappModel.MatchResult;
import Model.SpillerappModel.Interface.GameEngine;
import View.AdmappView.RegisterMovePanel;
import View.SpillerappView.MainFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

/**
 * Klassen tar seg av eventer som kommer fra panelet (Rangering og Søk)
 * Får referense fra panel klasse ved nesten samme navn
 */

public class DisplayPanelController implements EventHandler<ActionEvent> {

    private final MainFrame mainFrame;
    private final GameEngine gameEngine;

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


    /**
     * Metoden legger opp et nytt vindu for rangeringer
     */
    private void listRanks(){

        VBox ranksWindow = new VBox();
        Label r =  new Label("Rangeringer");
        r.getStyleClass().add("tittel");
        r.setMinWidth(280);
        ranksWindow.getChildren().addAll(r);
        Scene rankScene = new Scene(ranksWindow, 300, 500);
        rankScene.getStylesheets().add("CSS/rangering.css");

        Stage newWindow = new Stage();

        newWindow.setScene(rankScene);
        newWindow.setTitle("Rangering");
        writeRanksFromFile(ranksWindow);

        newWindow.show();
    }

    /**
     * Metoden skriver rangeringer fra fil over i nytt vindu.
     * Det blir også telt opp poeng for hver person, og sortert på antall poeng
     */
    private void writeRanksFromFile(VBox window) {
        ArrayList<FinalChessObject> chessObjects = new ArrayList<>();
        if (RegisterMovePanel.matchOverview.exists() && points.exists()) {
            try {
                FileInputStream f = new FileInputStream(RegisterMovePanel.matchOverview);
                try {
                    for (; ; ) {
                        fromFile = new ObjectInputStream(f);
                        Object obj = fromFile.readObject();
                        chessObjects.add((FinalChessObject) obj);
                    }
                } catch (ClassNotFoundException cl) {
                    cl.printStackTrace();
                } catch (EOFException eof) {
                    f.close();
                }
            } catch (IOException io) {
                io.printStackTrace();
            }

            Map<String, Double> namePoints = new HashMap<String, Double>();
            for (int i = 0; i < chessObjects.size(); i++) {
                // Forkorter referansen
                MatchResult result = chessObjects.get(i).getMatchResult();
                if (namePoints.containsKey(result.getMatchInfo().getName1())) {
                    givePoints(result, namePoints);

                } else {
                    namePoints.put(result.getMatchInfo().getName1(), 0.0);
                }
                if (namePoints.containsKey(result.getMatchInfo().getName2())) {
                    givePoints(result, namePoints);
                } else {
                    namePoints.put(result.getMatchInfo().getName2(), 0.0);
                }
            }
            try {
                FileInputStream s = new FileInputStream(points);
                    try {
                        fromPointsFile = new ObjectInputStream(s);


                        Set<Map.Entry<String, Double>> set = namePoints.entrySet();
                        List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String, Double>>(
                                set);

                        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
                            public int compare(Map.Entry<String, Double> o1,
                                               Map.Entry<String, Double> o2) {
                                return o2.getValue().compareTo(o1.getValue());
                            }
                        });
                        for (Map.Entry<String, Double> entry : list) {
                            window.getChildren().addAll(new Label(entry.getKey() + ": " + entry.getValue()));
                        }
                    }catch (EOFException eof){
                        s.close();
                    }
            }catch (IOException io){
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

    /**
     * Metoden blir hovedsakelig brukt for å forkorte metoden ''writeRanksFromFile'' ved
     * å bruke parameter-variabler
     */
    private void givePoints(MatchResult result, Map<String, Double> namePoints) {
        switch (result.getResult()) {
            case "1-0":
                result.getMatchInfo().setPoints1(1);
                namePoints.put(result.getMatchInfo().getName1(),
                        result.getMatchInfo().getPoints1());
                break;
            case "0-1":
                result.getMatchInfo().setPoints2(1);
                namePoints.put(result.getMatchInfo().getName2(),
                        result.getMatchInfo().getPoints2());
                break;
            case "1/2-1/2":
                result.getMatchInfo().setPoints1(0.5);
                result.getMatchInfo().setPoints2(0.5);
                namePoints.put(result.getMatchInfo().getName1(),
                        result.getMatchInfo().getPoints1());
                namePoints.put(result.getMatchInfo().getName2(),
                        result.getMatchInfo().getPoints2());
                break;
        }
    }



    /**
     * Metoden leser objekt fra fil ''oversikt'' ut på listview til panelet.
     * Bruker kan trykke på et objekt og få opp et sjakkbrett
     * som representerer objektet og alle trekk det inneholder
     */
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

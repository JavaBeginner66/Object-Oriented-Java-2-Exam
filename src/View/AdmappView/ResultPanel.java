package View.AdmappView;

import Controller.AdmappController.ResultPanelController;
import Model.AdmappModel.ChessMatchInfo;
import Model.AdmappModel.Interface.Engine;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.*;


public class ResultPanel extends HBox {

    private final File match = new File("match.dat");

    private Button register;
    private ComboBox chooseMatch;
    private ComboBox<String> resultBox;

    public ResultPanel(){
        this.setStyle("-fx-background-color: #c4c4c4;");
        this.setPadding(new Insets(10,10,10,10));
        this.setSpacing(10);

        componentSetup();
    }

    public void update(){
        ObjectInputStream fromFile;
        ObjectOutputStream createNewFile;

        if(match.exists()) {
            try {
                fromFile = new ObjectInputStream(new FileInputStream(match));
                try {
                    chooseMatch.getItems().clear();
                    while (true) {
                        try {
                            ChessMatchInfo match = (ChessMatchInfo) fromFile.readObject();
                            chooseMatch.getItems().addAll(match);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (EOFException eof) {
                    fromFile.close();
                }
            } catch (IOException io) {
                io.printStackTrace();
            }
        }else{
            try {
                createNewFile = new ObjectOutputStream(new FileOutputStream(match, true));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void componentSetup(){
        Label resultLabel = new Label("Resultat");
        chooseMatch = new ComboBox();
        resultBox = new ComboBox<String>();
        register = new Button("Registrer");

        chooseMatch.setPromptText("Velg Parti");
        resultBox.setPromptText("Resultat");
        resultBox.getItems().addAll("1-0", "0-1", "1/2-1/2");

        this.getChildren().addAll(resultLabel, chooseMatch, resultBox, register);
    }

    public void addListeners(MainFrame mainFrame, Engine engine){
        ResultPanelController listener = new ResultPanelController(mainFrame);
        register.setOnAction(listener);
    }

    /* Get methods */

    public ComboBox getChooseMatch() {
        return chooseMatch;
    }

    public ComboBox getResultBox() {
        return resultBox;
    }

    public Button getRegister() {
        return register;
    }
}

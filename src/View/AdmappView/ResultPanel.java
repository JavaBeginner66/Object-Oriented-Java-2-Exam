package View.AdmappView;

import Controller.AdmappController.ResultPanelController;
import Model.AdmappModel.ChessMatchInfo;
import Model.AdmappModel.Interface.Engine;
import View.AdmappView.Observer.Interface.Callback;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.*;


public class ResultPanel extends VBox implements Callback {

    public final static File resultFile = new File("result");

    private Button register;
    private ComboBox<ChessMatchInfo> chooseMatch;
    private ComboBox<String> resultBox;

    public ResultPanel(){
        this.getStyleClass().add("panel");
        this.setSpacing(10);

        componentSetup();
    }

    @Override
    public void update(){

        if(RegisterMatchPanel.matchFile.exists()) {
            try {
                FileInputStream f = new FileInputStream(RegisterMatchPanel.matchFile);
                try {
                    ChessMatchInfo matchInfo;
                    chooseMatch.getItems().clear();
                    for (; ;) {
                        ObjectInputStream fromFile = new ObjectInputStream(f);
                        matchInfo = (ChessMatchInfo) fromFile.readObject();
                        chooseMatch.getItems().addAll(matchInfo);
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
                ObjectOutputStream createNewFile = new ObjectOutputStream(new FileOutputStream(RegisterMatchPanel.matchFile, true));
                createNewFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void componentSetup(){
        Label resultLabel = new Label("Resultat");
        chooseMatch = new ComboBox<ChessMatchInfo>();
        resultBox = new ComboBox<String>();
        register = new Button("Registrer");

        chooseMatch.setPromptText("Velg Parti");
        resultBox.setPromptText("Resultat");
        resultBox.getItems().addAll("1-0", "0-1", "1/2-1/2");

        resultLabel.setMinWidth(200);
        chooseMatch.setMinWidth(200);
        resultBox.setMinWidth(200);
        chooseMatch.setMinWidth(200);

        register.setDisable(true);

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

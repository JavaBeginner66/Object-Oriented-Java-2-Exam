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

    public final static File match = new File("parti");

    private Button register;
    private ComboBox<ChessMatchInfo> chooseMatch;
    private ComboBox<String> resultBox;

    public ResultPanel(){
        this.setStyle("-fx-background-color: #c4c4c4;");
        this.setPadding(new Insets(10,10,10,10));
        this.setSpacing(10);

        componentSetup();
    }

    public void update(){

        if(match.exists()) {
            try {
                FileInputStream f = new FileInputStream(match);
                try {
                    ChessMatchInfo matchInfo;
                    chooseMatch.getItems().clear();
                    for (; ;) {
                        ObjectInputStream fromFile = new ObjectInputStream(f);
                        System.out.println(fromFile.readObject());
                        //chooseMatch.getItems().addAll(matchInfo);
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
                ObjectOutputStream createNewFile = new ObjectOutputStream(new FileOutputStream(match, true));
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

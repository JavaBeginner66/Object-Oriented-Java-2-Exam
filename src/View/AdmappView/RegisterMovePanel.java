package View.AdmappView;

import Controller.AdmappController.RegisterMovePanelController;
import Model.AdmappModel.Interface.Engine;
import Model.AdmappModel.MatchResult;
import View.AdmappView.Observer.Interface.Callback;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.*;

/**
 * Panel-klasse som har ansvar for registrer trekk komponenter
 */

public class RegisterMovePanel extends VBox implements Callback {

    public final static File resultFile = new File("resultat");
    public final static File matchOverview = new File("oversikt");

    private TextField moveDescription;
    private ComboBox moveComment;
    private Button saveMove;
    private Button saveAll;

    private ComboBox<MatchResult> matchResult;

    public RegisterMovePanel(){
        this.getStyleClass().add("panel");
        this.setSpacing(10);

        componentSetup();
    }
    @Override
    public void update(){

        if(ResultPanel.resultFile.exists()) {
            try {
                FileInputStream f = new FileInputStream(ResultPanel.resultFile);
                try {
                    MatchResult result;
                    matchResult.getItems().clear();
                    for (; ;) {
                        ObjectInputStream fromFile = new ObjectInputStream(f);
                        result = (MatchResult)fromFile.readObject();
                        matchResult.getItems().addAll(result);
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
                ObjectOutputStream createNewFile = new ObjectOutputStream(new FileOutputStream(ResultPanel.resultFile, true));
                createNewFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    /**
     * Metoden resetter TextField felt
     */
    public void emptyFields(){
        this.moveDescription.setText("");
    }

    @Override
    public void componentSetup(){
        Label registerMoveLabel = new Label("Registrer Trekk");
        matchResult = new ComboBox<MatchResult>();
        moveDescription = new TextField();
        moveComment = new ComboBox();
        saveMove = new Button("Lagre Trekk");
        saveAll = new Button("Lagre Data");

        moveDescription.setPromptText("Trekk");
        moveComment.setPromptText("Beskrivelse");
        matchResult.setPromptText("Velg parti");

        registerMoveLabel.setMinWidth(200);
        matchResult.setMinWidth(200);
        moveDescription.setMinWidth(200);
        moveComment.setMinWidth(200);
        matchResult.setMinWidth(200);

        saveAll.setDisable(true);
        saveMove.setDisable(true);

        moveComment.getItems().addAll("!!", "!", "!?", "?!", "?", "??");

        this.getChildren().addAll(registerMoveLabel, matchResult, moveDescription, moveComment, saveMove,saveAll);

    }

    public void addListeners(MainFrame mainFrame, Engine engine){
        RegisterMovePanelController listener = new RegisterMovePanelController(mainFrame);
        saveMove.setOnAction(listener);
        saveAll.setOnAction(listener);
    }

    /* Get methods */

    public TextField getMoveDescription() {
        return moveDescription;
    }

    public ComboBox getMoveComment() {
        return moveComment;
    }

    public Button getSaveAll() {
        return saveAll;
    }

    public ComboBox<MatchResult> getMatchResult() {
        return matchResult;
    }

    public Button getSaveMove() {
        return saveMove;
    }
}

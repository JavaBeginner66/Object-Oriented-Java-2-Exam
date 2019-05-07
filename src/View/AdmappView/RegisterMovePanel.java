package View.AdmappView;

import Model.AdmappModel.Interface.Engine;
import Model.AdmappModel.MatchResult;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.File;


public class RegisterMovePanel extends HBox {

    public final static File resultFile = new File("resultat");

    private TextField moveDescription;
    private ComboBox moveComment;

    private ComboBox<MatchResult> matchResult;

    public RegisterMovePanel(){
        this.setStyle("-fx-background-color: #c4c4c4;");
        this.setPadding(new Insets(10,10,10,10));
        this.setSpacing(10);

        componentSetup();
    }

    private void update(){

    }

    private void componentSetup(){
        Label registerMoveLabel = new Label("Registrer Trekk");
        matchResult = new ComboBox<MatchResult>();
        moveDescription = new TextField();
        moveComment = new ComboBox();

        moveDescription.setPromptText("Trekk");
        moveComment.setPromptText("Beskrivelse");
        matchResult.setPromptText("Velg parti");

        moveComment.getItems().addAll("!!", "!", "!?", "?!", "?", "??");

        this.getChildren().addAll(registerMoveLabel, matchResult, moveDescription, moveComment);

    }

    public void addListeners(MainFrame mainFrame, Engine engine){

    }

    /* Get methods */

    public TextField getMoveDescription() {
        return moveDescription;
    }

    public ComboBox getMoveComment() {
        return moveComment;
    }
}

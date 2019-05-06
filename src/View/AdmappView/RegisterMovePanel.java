package View.AdmappView;

import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class RegisterMovePanel extends HBox {

    private TextField moveDescription;
    private ComboBox moveComment;

    public RegisterMovePanel(){
        this.setStyle("-fx-background-color: #c4c4c4;");
        this.setPadding(new Insets(10,10,10,10));
        this.setSpacing(10);

        componentSetup();
    }

    private void componentSetup(){
        Label registerMoveLabel = new Label("Registrer Trekk");
        moveDescription = new TextField();
        moveComment = new ComboBox();

        moveDescription.setPromptText("Trekk");
        moveComment.setPromptText("Beskrivelse");

        moveComment.getItems().addAll("!!", "!", "!?", "?!", "?", "??");

        this.getChildren().addAll(registerMoveLabel, moveDescription, moveComment);

    }

    /* Get methods */

    public TextField getMoveDescription() {
        return moveDescription;
    }

    public ComboBox getMoveComment() {
        return moveComment;
    }
}

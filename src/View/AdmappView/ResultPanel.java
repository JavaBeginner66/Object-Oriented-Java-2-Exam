package View.AdmappView;

import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class ResultPanel extends HBox {

    private ComboBox chooseMatch;
    private TextField resultBox;

    public ResultPanel(){
        this.setStyle("-fx-background-color: #c4c4c4;");
        this.setPadding(new Insets(10,10,10,10));
        this.setSpacing(10);

        componentSetup();
    }

    private void componentSetup(){
        Label resultLabel = new Label("Resultat");
        chooseMatch = new ComboBox();
        resultBox = new TextField();

        chooseMatch.setPromptText("Velg Parti");
        resultBox.setPromptText("Vinn, Tap, Remi?");

        this.getChildren().addAll(resultLabel, chooseMatch, resultBox);
    }
}

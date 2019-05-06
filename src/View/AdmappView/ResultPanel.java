package View.AdmappView;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

import java.awt.*;

public class ResultPanel extends HBox {

    public ResultPanel(){
        this.setStyle("-fx-background-color: #ed0b53;");
        this.setPadding(new Insets(10,10,10,10));
        this.setSpacing(10);

        componentSetup();
    }

    private void componentSetup(){
        Label resultLabel = new Label("Resultat");
    }
}

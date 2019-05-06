package View.AdmappView;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

import java.awt.*;

public class RegisterMatchPanel extends HBox {

    public RegisterMatchPanel(){
        this.setStyle("-fx-background-color: #e03eca;");
        this.setPadding(new Insets(10,10,10,10));
        this.setSpacing(10);

        componentSetup();
    }

    private void componentSetup(){
        Label matchLabel = new Label("Registrer sjakkpartier");
    }
}

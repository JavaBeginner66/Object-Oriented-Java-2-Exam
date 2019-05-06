package View.AdmappView;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

import java.awt.*;

public class RegisterPlayerPanel extends HBox {

    private TextField registerName;
    private Button register;

    public RegisterPlayerPanel(){
        this.setStyle("-fx-background-color: #a0b1ed;");
        this.setPadding(new Insets(10,10,10,10));
        this.setSpacing(10);

        componentSetup();
    }

    private void componentSetup(){
        Label nameLabel = new Label("Navn");
    }
}

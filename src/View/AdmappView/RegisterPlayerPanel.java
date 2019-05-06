package View.AdmappView;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;



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
        registerName = new TextField();
        register = new Button("Registrer");

        this.getChildren().addAll(nameLabel, registerName, register);
    }
}

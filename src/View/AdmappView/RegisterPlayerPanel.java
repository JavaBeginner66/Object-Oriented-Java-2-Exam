package View.AdmappView;

import Controller.AdmappController.RegisterPlayerController;
import Model.AdmappModel.Interface.Engine;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.File;


public class RegisterPlayerPanel extends HBox {

    public final static File playerFile = new File("deltakere");

    private TextField registerName;
    private Button register;

    public RegisterPlayerPanel(){
        this.setStyle("-fx-background-color: #c4c4c4;");
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

    public void addListeners(MainFrame mainFrame, Engine engine){
        RegisterPlayerController listener = new RegisterPlayerController(mainFrame, engine, registerName);
        register.setOnAction(listener);
    }


    /* Get methods */

    public TextField getRegisterName() {
        return registerName;
    }

    public Button getRegister() {
        return register;
    }
}

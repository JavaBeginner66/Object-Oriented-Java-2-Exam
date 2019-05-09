package View.AdmappView;

import Controller.AdmappController.RegisterPlayerController;
import Model.AdmappModel.Interface.Engine;
import View.AdmappView.Observer.Interface.Callback;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;


public class RegisterPlayerPanel extends VBox implements Callback {

    public final static File playerFile = new File("deltakere");

    private TextField registerName;
    private Button register;

    public RegisterPlayerPanel(){
        this.getStyleClass().add("panel");
        this.setSpacing(10);

        componentSetup();
    }

    private void componentSetup(){
        Label nameLabel = new Label("Navn");
        registerName = new TextField();
        register = new Button("Registrer");
        register.setDisable(true);

        nameLabel.setMinWidth(200);
        registerName.setMinWidth(200);

        this.getChildren().addAll(nameLabel, registerName, register);

    }

    @Override
    public void update() {
        registerName.setText("");
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

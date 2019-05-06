package View.AdmappView;

import Model.AdmappModel.Interface.Engine;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class RegisterMatchPanel extends HBox {

    private ComboBox participant;
    private Button registerMatch;
    private TextField time;
    private TextField day;
    private TextField month;
    private TextField year;


    public RegisterMatchPanel(){
        this.setStyle("-fx-background-color: #c4c4c4;");
        this.setPadding(new Insets(10,10,10,10));
        this.setSpacing(10);

        componentSetup();
    }

    private void componentSetup(){
        Label matchLabel = new Label("Registrer Sjakkparti");
        participant = new ComboBox();
        registerMatch = new Button("Registrer");
        time = new TextField();
        day = new TextField();
        month = new TextField();
        year = new TextField();

        participant.setPromptText("Velg navn");
        time.setPromptText("Klokkeslett");
        day.setPromptText("Dag");
        month.setPromptText("Månde");
        year.setPromptText("år");

        time.setMaxWidth(80);
        day.setMaxWidth(80);
        month.setMaxWidth(80);
        year.setMaxWidth(80);

        this.getChildren().addAll(matchLabel, participant, time, day, month, year, registerMatch);
    }

    public void addListeners(MainFrame mainFrame, Engine engine){

    }

    public void update(){
        try {
            DataInputStream fromFile = new DataInputStream(new FileInputStream("deltakere.dat"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /* Get methods */

    public ComboBox getParticipant() {
        return participant;
    }

    public TextField getTime() {
        return time;
    }

    public TextField getDay() {
        return day;
    }

    public TextField getMonth() {
        return month;
    }

    public TextField getYear() {
        return year;
    }


}

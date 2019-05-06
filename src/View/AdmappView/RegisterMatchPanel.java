package View.AdmappView;

import Model.AdmappModel.Interface.Engine;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.io.*;


public class RegisterMatchPanel extends HBox {

    private ComboBox<String> participant;
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
        participant = new ComboBox<String>();
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
        participant.setMinWidth(130);

        this.getChildren().addAll(matchLabel, participant, time, day, month, year, registerMatch);
    }

    public void addListeners(MainFrame mainFrame, Engine engine){

    }

    public void update() {

        DataInputStream fromFile;
        DataOutputStream toFile;

        try{
            fromFile = new DataInputStream(new FileInputStream("deltakere.dat"));
            toFile = new DataOutputStream(new FileOutputStream("parti.dat"));
            try{
                participant.getItems().clear();
                while(true){
                    participant.getItems().addAll(fromFile.readUTF());
                }
            }catch(EOFException eof){
                fromFile.close();
                toFile.close();
            }
        }catch (IOException io){
            io.printStackTrace();
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

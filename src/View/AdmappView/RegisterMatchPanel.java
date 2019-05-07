package View.AdmappView;

import Controller.AdmappController.RegisterMatchController;
import Model.AdmappModel.Interface.Engine;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.io.*;


public class RegisterMatchPanel extends HBox {

    public final static File matchFile = new File("parti");

    private ComboBox<String> participant1;
    private ComboBox<String> participant2;
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
        participant1 = new ComboBox<String>();
        participant2 = new ComboBox<String>();
        registerMatch = new Button("Registrer");
        time = new TextField();
        day = new TextField();
        month = new TextField();
        year = new TextField();

        participant1.setPromptText("Velg navn");
        participant2.setPromptText("Velg navn");
        time.setPromptText("Klokkeslett");
        day.setPromptText("Dag");
        month.setPromptText("Månde");
        year.setPromptText("år");

        time.setMaxWidth(80);
        day.setMaxWidth(80);
        month.setMaxWidth(80);
        year.setMaxWidth(80);
        participant1.setMinWidth(150);
        participant2.setMinWidth(150);

        this.getChildren().addAll(matchLabel, participant1,participant2, time, day, month, year, registerMatch);
    }



    public void update() {

        DataInputStream fromFile;

        try{
            fromFile = new DataInputStream(new FileInputStream(RegisterPlayerPanel.playerFile));
            try{
                participant1.getItems().clear();
                participant2.getItems().clear();
                while(true){
                    String name = fromFile.readUTF();
                    participant1.getItems().addAll(name);
                    participant2.getItems().addAll(name);
                }
            }catch(EOFException eof){
                fromFile.close();
            }
        }catch (IOException io){
            io.printStackTrace();
        }
    }

    public void emptyFields(){
        time.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
    }

    public void addListeners(MainFrame mainFrame, Engine engine){
        RegisterMatchController listener = new RegisterMatchController(mainFrame, engine);
        registerMatch.setOnAction(listener);
    }
    /* Get methods */

    public ComboBox getParticipant1() {
        return participant1;
    }
    public ComboBox getParticipant2() {
        return participant2;
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

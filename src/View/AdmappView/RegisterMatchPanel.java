package View.AdmappView;

import Controller.AdmappController.RegisterMatchController;
import Model.AdmappModel.Interface.Engine;
import View.AdmappView.Observer.Interface.Callback;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.*;

/**
 * Panel-klasse som har ansvar for registrer parti komponenter
 */

public class RegisterMatchPanel extends VBox implements Callback {

    public final static File matchFile = new File("parti");

    private ComboBox<String> participant1;
    private ComboBox<String> participant2;
    private Button registerMatch;
    private TextField time;
    private TextField day;
    private TextField month;
    private TextField year;


    public RegisterMatchPanel(){
        this.getStyleClass().add("panel");
        this.setSpacing(10);

        componentSetup();

    }
    @Override
    public void componentSetup(){
        Label matchLabel = new Label("Registrer Sjakkparti");
        participant1 = new ComboBox<String>();
        participant2 = new ComboBox<String>();
        registerMatch = new Button("Registrer");
        time = new TextField();
        day = new TextField();
        month = new TextField();
        year = new TextField();

        registerMatch.setDisable(true);

        participant1.setPromptText("Velg navn");
        participant2.setPromptText("Velg navn");
        time.setPromptText("Klokkeslett");
        day.setPromptText("Dag");
        month.setPromptText("Måned");
        year.setPromptText("År");

        matchLabel.setMinWidth(200);
        participant1.setMinWidth(200);
        participant2.setMinWidth(200);
        time.setMaxWidth(200);
        day.setMaxWidth(200);
        month.setMaxWidth(200);
        year.setMaxWidth(200);

        this.getChildren().addAll(matchLabel, participant1,participant2, time, day, month, year, registerMatch);
    }


    @Override
    public void update() {

        DataInputStream fromFile;
        if(RegisterPlayerPanel.playerFile.exists()) {
            try {
                fromFile = new DataInputStream(new FileInputStream(RegisterPlayerPanel.playerFile));
                try {
                    participant1.getItems().clear();
                    participant2.getItems().clear();
                    while (true) {
                        String name = fromFile.readUTF();
                        participant1.getItems().addAll(name);
                        participant2.getItems().addAll(name);
                    }
                } catch (EOFException eof) {
                    fromFile.close();
                }
            } catch (IOException io) {
                io.printStackTrace();
            }
        }else{
            try {
                ObjectOutputStream createNewFile = new ObjectOutputStream(new FileOutputStream(RegisterPlayerPanel.playerFile, true));
                createNewFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Metoden resetter TextField felt
     */
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

    public Button getRegisterMatch() {
        return registerMatch;
    }
}

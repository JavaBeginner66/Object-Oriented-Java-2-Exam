package Controller.AdmappController;

import Model.AdmappModel.Interface.Engine;
import View.AdmappView.MainFrame;
import View.AdmappView.RegisterPlayerPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * Klassen tar seg av eventen fra ''registrer'' deltaker,
 * og også generelle disabling/enabling
 * Får referense fra panel klasse ved nesten samme navn
 */

public class RegisterPlayerController implements EventHandler<ActionEvent> {

    private DataOutputStream toFile;
    private TextField registerName;

    private final MainFrame mainFrame;
    private final Engine engine;

    public RegisterPlayerController(MainFrame mainFrame, Engine engine, TextField registerName){
        this.mainFrame = mainFrame;
        this.engine = engine;
        this.registerName = registerName;

        mainFrame.getRegisterPlayerPanel().getRegisterName().textProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue.equals(""))
                mainFrame.getRegisterPlayerPanel().getRegister().setDisable(false);
            else
                mainFrame.getRegisterPlayerPanel().getRegister().setDisable(true);
        });
    }

    /* Ligger bare en knapp i RegisterPlayerPanel, så slipper å sjekke*/
    @Override
    public void handle(ActionEvent event) {
        writeToFile();
    }

    /**
     * Skriver navn til fil ''deltakere''
     */
    private void writeToFile(){

        try {
            toFile = new DataOutputStream(new FileOutputStream(RegisterPlayerPanel.playerFile, true));
            toFile.writeUTF(registerName.getText());
            mainFrame.getRegisterPlayerPanel().update();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                toFile.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }
            /* Oppdater navnliste*/
            engine.updateGUI();
        }
    }
}

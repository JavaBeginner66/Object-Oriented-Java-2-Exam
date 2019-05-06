package Controller.AdmappController;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class RegisterPlayerController implements EventHandler<ActionEvent> {

    private DataOutputStream toFile;
    private TextField registerName;

    public RegisterPlayerController(TextField registerName){
        this.registerName = registerName;
    }

    /* Ligger bare en knapp i RegisterPlayerPanel, så slipper å sjekke*/
    @Override
    public void handle(ActionEvent event) {
        writeToFile();
    }

    private void writeToFile(){

        try {
            toFile = new DataOutputStream(new FileOutputStream("deltakere.dat", true));
            toFile.writeChars(registerName.getText());
            registerName.setText("");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                toFile.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
}

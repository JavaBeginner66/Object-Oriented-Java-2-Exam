package Controller.AdmappController;

import View.AdmappView.MainFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RegisterMatchController implements EventHandler<ActionEvent> {

    private MainFrame mainFrame;

    public RegisterMatchController(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    /* Ligger bare en knapp i RegisterPlayerPanel, så slipper å sjekke*/
    @Override
    public void handle(ActionEvent event) {
        writeToFile();
    }

    private void writeToFile(){
        mainFrame.getRegisterMatchPanel().getParticipant().getValue();
    }
}

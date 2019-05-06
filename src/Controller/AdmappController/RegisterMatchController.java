package Controller.AdmappController;

import Model.ChessMatchDate;
import View.AdmappView.MainFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
        ObjectOutputStream toFile;
        String name = (String)mainFrame.getRegisterMatchPanel().getParticipant().getValue();
        String time = mainFrame.getRegisterMatchPanel().getTime().getText();
        String day = mainFrame.getRegisterMatchPanel().getDay().getText();
        String month = mainFrame.getRegisterMatchPanel().getMonth().getText();
        String year = mainFrame.getRegisterMatchPanel().getYear().getText();

        ChessMatchDate matchDate = new ChessMatchDate(name, time, day, month, year);

        try {
            toFile = new ObjectOutputStream(new FileOutputStream("parti.dat",true));
            toFile.writeObject(matchDate);
            toFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            mainFrame.getRegisterMatchPanel().emptyFields();
        }
    }
}

package Controller.AdmappController;

import Model.AdmappModel.ChessMatchInfo;
import Model.AdmappModel.Interface.Engine;
import View.AdmappView.MainFrame;
import View.AdmappView.RegisterMatchPanel;
import View.AdmappView.ResultPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class RegisterMatchController implements EventHandler<ActionEvent> {

    public static boolean timeCheck = false;
    public static boolean dayCheck = false;
    public static boolean monthCheck = false;
    public static boolean yearCheck = false;

    private MainFrame mainFrame;
    private Engine engine;

    public RegisterMatchController(MainFrame mainFrame, Engine engine){
        this.mainFrame = mainFrame;
        this.engine = engine;

        checkEmptyFields();
    }

    /* Ligger bare en knapp i RegisterPlayerPanel, så slipper å sjekke*/
    @Override
    public void handle(ActionEvent event) {
        writeToFile();
    }

    private void writeToFile(){
        ObjectOutputStream toFile;
        String name1 = (String)mainFrame.getRegisterMatchPanel().getParticipant1().getValue();
        String name2 = (String)mainFrame.getRegisterMatchPanel().getParticipant2().getValue();
        String time = mainFrame.getRegisterMatchPanel().getTime().getText();
        String day = mainFrame.getRegisterMatchPanel().getDay().getText();
        String month = mainFrame.getRegisterMatchPanel().getMonth().getText();
        String year = mainFrame.getRegisterMatchPanel().getYear().getText();

        ChessMatchInfo matchDate = new ChessMatchInfo(name1,name2, time, day, month, year);

        try {
            toFile = new ObjectOutputStream(new FileOutputStream(RegisterMatchPanel.matchFile, true));
            toFile.writeObject(matchDate);
            toFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            mainFrame.getRegisterMatchPanel().emptyFields();
            /* Oppdater matchliste*/
            mainFrame.getResultPanel().update();
        }
    }

    private void checkEmptyFields(){

        mainFrame.getRegisterMatchPanel().getTime().textProperty().addListener((observable, oldValue, newValue) -> {
            timeCheck = !newValue.equals("");
            triggerCheck();
        });
        mainFrame.getRegisterMatchPanel().getDay().textProperty().addListener((observable, oldValue, newValue) -> {
            dayCheck = !newValue.equals("");
            triggerCheck();
        });
        mainFrame.getRegisterMatchPanel().getMonth(.textProperty().addListener((observable, oldValue, newValue) -> {
            monthCheck = !newValue.equals("");
            triggerCheck();
        });
        mainFrame.getRegisterMatchPanel().getYear().textProperty().addListener((observable, oldValue, newValue) -> {
            yearCheck = !newValue.equals("");
            triggerCheck();
        });
    }

    private void triggerCheck(){
        mainFrame.getRegisterMatchPanel().getRegisterMatch().setDisable(!timeCheck || !dayCheck || !monthCheck || !yearCheck);
    }
}

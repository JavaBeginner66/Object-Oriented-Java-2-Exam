package Controller.AdmappController;

import Model.AdmappModel.ChessMatchInfo;
import Model.AdmappModel.Interface.Engine;
import View.AdmappView.MainFrame;
import View.AdmappView.RegisterMatchPanel;
import View.AdmappView.ResultPanel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class RegisterMatchController implements EventHandler<ActionEvent> {

    private static boolean timeCheck = false;
    private static boolean dayCheck = false;
    private static boolean monthCheck = false;
    private static boolean yearCheck = false;
    private static boolean person1 = false;
    private static boolean person2 = false;

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
        mainFrame.getRegisterMatchPanel().getMonth().textProperty().addListener((observable, oldValue, newValue) -> {
            monthCheck = !newValue.equals("");
            triggerCheck();
        });
        mainFrame.getRegisterMatchPanel().getYear().textProperty().addListener((observable, oldValue, newValue) -> {
            yearCheck = !newValue.equals("");
            triggerCheck();
        });
        mainFrame.getRegisterMatchPanel().getParticipant1().valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                person1 = newValue != null;
                triggerCheck();
            }
        });
        mainFrame.getRegisterMatchPanel().getParticipant2().valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                person2 = newValue != null;
                triggerCheck();
            }
        });
    }

    private void triggerCheck(){
            mainFrame.getRegisterMatchPanel().getRegisterMatch().setDisable(!timeCheck || !dayCheck || !monthCheck || !yearCheck
                    || !person1 || !person2 || checkDuplicateNames());
    }

    private boolean checkDuplicateNames(){
        String name1 = (String)mainFrame.getRegisterMatchPanel().getParticipant1().getValue();
        String name2 = (String)mainFrame.getRegisterMatchPanel().getParticipant2().getValue();
        return (name1.equals(name2));

    }
}

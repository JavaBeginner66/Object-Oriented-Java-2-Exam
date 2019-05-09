package Controller.AdmappController;

import Model.AdmappModel.ChessMatchInfo;
import Model.AdmappModel.MatchResult;
import View.AdmappView.MainFrame;
import View.AdmappView.RegisterMatchPanel;
import View.AdmappView.ResultPanel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.io.*;

/**
 * Klassen tar seg av events som kommer av ''registrer'' resultat.
 * Får referense fra panel klasse ved nesten samme navn
 */

public class ResultPanelController implements EventHandler<ActionEvent> {

    private static boolean matchCheck = false;
    private static boolean resultCheck = false;

    private final MainFrame mainFrame;

    public ResultPanelController(MainFrame mainFrame){
        this.mainFrame = mainFrame;

        checkEmptyFields();
    }

    @Override
    public void handle(ActionEvent event) {
        writeToFile();
    }

    /**
     * Metoden skriver resultat til fil ''result''
     */
    private void writeToFile() {
        ObjectOutputStream toFile;
        MatchResult result = new MatchResult((ChessMatchInfo)mainFrame.getResultPanel().getChooseMatch().getValue(),
                                             (String)mainFrame.getResultPanel().getResultBox().getValue());

        try {
            toFile = new ObjectOutputStream(new FileOutputStream(ResultPanel.resultFile, true));
            toFile.writeObject(result);
            toFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            /* Oppdater resultatliste*/
            mainFrame.getRegisterMovePanel().update();
        }
    }

    /**
     * Metoden sørger for at comboboksen ikke er null når bruker trykker registrer
     */
    private void checkEmptyFields(){
        mainFrame.getResultPanel().getChooseMatch().valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                matchCheck = newValue != null;
                triggerCheck();
            }
        });
        mainFrame.getResultPanel().getResultBox().valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                resultCheck = newValue != null;
                triggerCheck();
            }
        });
    }

    private void triggerCheck(){
        mainFrame.getResultPanel().getRegister().setDisable(!matchCheck || !resultCheck);
    }
}

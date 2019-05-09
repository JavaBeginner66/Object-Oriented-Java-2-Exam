package Controller.AdmappController;

import Model.AdmappModel.FinalChessObject;
import Model.AdmappModel.MatchResult;
import Model.AdmappModel.MoveDescriptionObject;
import View.AdmappView.MainFrame;
import View.AdmappView.RegisterMatchPanel;
import View.AdmappView.RegisterMovePanel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 * Klassen tar seg av registrering av trekk, i tilleg til
 * å skrive inn det endelige objektet til fil
 * Får referense fra panel klasse ved nesten samme navn
 */

public class RegisterMovePanelController implements EventHandler<ActionEvent> {

    private static boolean matchCheck = false;
    private static boolean moveCheck = false;
    private static boolean commentCheck = false;

    private final MainFrame mainFrame;

    private TreeMap<Integer, MoveDescriptionObject> moves = new TreeMap<>();

    private int countMapItems = 1;

    public RegisterMovePanelController(MainFrame mainFrame){
        this.mainFrame = mainFrame;

        checkEmptyFields();
    }

    @Override
    public void handle(ActionEvent event) {
        Button b = (Button) event.getSource();
        String s = b.getText();
        switch (s){
            case "Lagre Trekk":
                saveMoveToMap();
                break;
            case "Lagre Data":
                saveMatchObjectToFile();
                break;
        }
    }

    /**
     * Lager først et objekt som tar imot hvilket trekk som er tatt + kommentaren,
     * og setter objektet inn i et TreeMap med countMapItems som nøkkel for sortering.
     */
    private void saveMoveToMap(){
        moves.put(countMapItems,
                  new MoveDescriptionObject(
                          mainFrame.getRegisterMovePanel().getMoveDescription().getText(),
                          (String)mainFrame.getRegisterMovePanel().getMoveComment().getValue()
                  ));

      countMapItems++;

        mainFrame.getRegisterMovePanel().emptyFields();
        if(mainFrame.getRegisterMovePanel().getMatchResult() != null)
            mainFrame.getRegisterMovePanel().getMatchResult().setDisable(true);
        mainFrame.getRegisterMovePanel().getSaveAll().setDisable(false);

    }

    /**
     * Skriver endelig objekt med parti + trekk til fil ''oversikt''.
     */
    private void saveMatchObjectToFile(){
        countMapItems = 1;
        ObjectOutputStream toFile;
        FinalChessObject chessObject = new FinalChessObject((MatchResult)mainFrame.getRegisterMovePanel().getMatchResult().getValue(), moves);
        try {
            toFile = new ObjectOutputStream(new FileOutputStream(RegisterMovePanel.matchOverview, true));
            toFile.writeObject(chessObject);
            toFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            mainFrame.getRegisterMovePanel().emptyFields();
            mainFrame.getRegisterMovePanel().getMatchResult().setDisable(false);
            mainFrame.getRegisterMovePanel().getSaveAll().setDisable(true);
        }

    }
    /**
     * Sjekker om bruker har valide verdier i felt (ikke null)
     */
    private void checkEmptyFields(){

        mainFrame.getRegisterMovePanel().getMatchResult().valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                mainFrame.getRegisterMovePanel().getSaveAll().setDisable(true);
                matchCheck = newValue != null;
                triggerCheck();
            }
        });

        mainFrame.getRegisterMovePanel().getMoveComment().valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                moveCheck = newValue != null;
                triggerCheck();
            }
        });
        mainFrame.getRegisterMovePanel().getMoveDescription().textProperty().addListener((observable, oldValue, newValue) -> {
            commentCheck = !newValue.equals("");
            triggerCheck();
        });
    }

    private void triggerCheck(){

        mainFrame.getRegisterMovePanel().getSaveMove().setDisable(!matchCheck || !moveCheck || !commentCheck);
    }

}

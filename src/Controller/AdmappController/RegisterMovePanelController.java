package Controller.AdmappController;

import Model.AdmappModel.FinalChessObject;
import Model.AdmappModel.MatchResult;
import Model.AdmappModel.MoveDescriptionObject;
import View.AdmappView.MainFrame;
import View.AdmappView.RegisterMatchPanel;
import View.AdmappView.RegisterMovePanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class RegisterMovePanelController implements EventHandler<ActionEvent> {

    private MainFrame mainFrame;

    private TreeMap<Integer, MoveDescriptionObject> moves = new TreeMap<>();

    private int countMapItems = 1;

    public RegisterMovePanelController(MainFrame mainFrame){
        this.mainFrame = mainFrame;
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

        /*
        Set keys = moves.keySet();
        for (Iterator i = keys.iterator(); i.hasNext();) {
            String s = (String) i.next();
            System.out.print(moves.get(s));
        }
        */
      countMapItems++;
        /* Disable Comboboksen for å ''locke'' inn til objektet*/
        mainFrame.getRegisterMovePanel().emptyFields();
        mainFrame.getRegisterMovePanel().getMatchResult().setDisable(true);
    }

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
        }

    }

}

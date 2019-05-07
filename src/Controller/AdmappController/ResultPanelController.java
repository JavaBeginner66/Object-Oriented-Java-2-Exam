package Controller.AdmappController;

import Model.AdmappModel.ChessMatchInfo;
import Model.AdmappModel.MatchResult;
import View.AdmappView.MainFrame;
import View.AdmappView.RegisterMatchPanel;
import View.AdmappView.ResultPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.*;

public class ResultPanelController implements EventHandler<ActionEvent> {

    private MainFrame mainFrame;

    public ResultPanelController(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    @Override
    public void handle(ActionEvent event) {
        writeToFile();
    }

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
}

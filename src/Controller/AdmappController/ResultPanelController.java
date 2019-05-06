package Controller.AdmappController;

import Model.AdmappModel.ChessMatchInfo;
import View.AdmappView.MainFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ResultPanelController implements EventHandler<ActionEvent> {

    private MainFrame mainFrame;

    public ResultPanelController(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    @Override
    public void handle(ActionEvent event) {
        writeFromFile();
    }

    private void writeFromFile() {
    }
}

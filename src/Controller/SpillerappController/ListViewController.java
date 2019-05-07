package Controller.SpillerappController;

import Model.AdmappModel.FinalChessObject;
import Model.AdmappModel.MoveDescriptionObject;
import View.SpillerappView.MainFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.Collections;
import java.util.TreeMap;

public class ListViewController implements EventHandler<MouseEvent> {

    private MainFrame mainFrame;

    public ListViewController(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    @Override
    public void handle(MouseEvent event) {
        mainFrame.getDisplayPanel().getMovesDescription().clear();
        for(int i = 0; i<10; i++){
            FinalChessObject c = (FinalChessObject)mainFrame.getDisplayPanel().getMatches().getSelectionModel().getSelectedItem();
            TreeMap<Integer, MoveDescriptionObject> moves = c.getMoves();
            mainFrame.getDisplayPanel().getMovesDescription().appendText(i + ": " + moves.get(i) +  "\n");
        }

    }
}

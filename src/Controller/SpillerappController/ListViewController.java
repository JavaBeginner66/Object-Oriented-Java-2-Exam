package Controller.SpillerappController;

import Model.AdmappModel.FinalChessObject;
import Model.AdmappModel.MoveDescriptionObject;
import Model.SpillerappModel.BoardManager;
import View.SpillerappView.MainFrame;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.TreeMap;

public class ListViewController implements EventHandler<MouseEvent> {

    private MainFrame mainFrame;

    public ListViewController(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    @Override
    public void handle(MouseEvent event) {
        listMoves();
        initializeChessBoard(mainFrame);
    }

    private void listMoves(){
        mainFrame.getDisplayPanel().getMovesDescription().clear();
        FinalChessObject c = (FinalChessObject)mainFrame.getDisplayPanel().getMatches().getSelectionModel().getSelectedItem();
        TreeMap<Integer, MoveDescriptionObject> moves = c.getMoves();
        for(int i = 1; i<moves.size(); i++){
            mainFrame.getDisplayPanel().getMovesDescription().appendText(i + ": " + moves.get(i) +  "\n");
        }

    }

    private void initializeChessBoard(MainFrame mainFrame){
        BoardManager board = new BoardManager(mainFrame);
    }
}

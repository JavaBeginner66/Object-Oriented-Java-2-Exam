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
    private BoardManager boardManager;

    public ListViewController(MainFrame mainFrame, BoardManager boardManager){
        this.mainFrame = mainFrame;
        this.boardManager = boardManager;
    }

    @Override
    public void handle(MouseEvent event) {
        listMoves();
        NavigationPanelController.moveCount = 1;
        NavigationPanelController.playerTurn = 1;
    }

    private void listMoves(){
        mainFrame.getDisplayPanel().getMovesDescription().clear();
        FinalChessObject c = (FinalChessObject)mainFrame.getDisplayPanel().getMatches().getSelectionModel().getSelectedItem();
        try {
            TreeMap<Integer, MoveDescriptionObject> moves = c.getMoves();
            for(int i = 1; i<=moves.size(); i++) {
                mainFrame.getDisplayPanel().getMovesDescription().appendText(i + ": " + moves.get(i) + "\n");
            }
            initializeChessBoard(mainFrame);
        }catch (NullPointerException e){
            // Det her må man innrømme at var smart
            mainFrame.getDisplayPanel().getSearchArea().requestFocus();
        }
    }

    private void initializeChessBoard(MainFrame mainFrame){
        boardManager.createBoard();
    }
}

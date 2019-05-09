package Controller.SpillerappController;

import Model.AdmappModel.FinalChessObject;
import Model.AdmappModel.MoveDescriptionObject;
import Model.SpillerappModel.BoardManager;
import View.SpillerappView.MainFrame;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.TreeMap;

/**
 * Klassen har ansvar for å printe ut alle trekk og kommentarer til
 * objektet bruker trykker på, i tekstfeltet til venstre
 */

public class ListViewController implements EventHandler<MouseEvent> {

    private final MainFrame mainFrame;
    private final BoardManager boardManager;

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

    /**
     * Metoden finner trekk-objektet og printer dem ut i textarea
     */
    private void listMoves(){
        FinalChessObject c = (FinalChessObject)mainFrame.getDisplayPanel().getMatches().getSelectionModel().getSelectedItem();
        //System.out.println(c.getMoves());
        try {
            TreeMap<Integer, MoveDescriptionObject> moves = c.getMoves();
            mainFrame.getDisplayPanel().getMovesDescription().clear();
            for(int i = 1; i<=moves.size(); i++) {
                mainFrame.getDisplayPanel().getMovesDescription().appendText(i + ": " + moves.get(i) + "\n");
                //System.out.print(moves.size());
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

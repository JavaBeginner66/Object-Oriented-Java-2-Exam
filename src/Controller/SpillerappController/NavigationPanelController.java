package Controller.SpillerappController;

import Model.AdmappModel.FinalChessObject;
import Model.AdmappModel.MoveDescriptionObject;
import Model.SpillerappModel.BoardManager;
import Model.SpillerappModel.Interface.GameEngine;
import View.SpillerappView.MainFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.TreeMap;

public class NavigationPanelController implements EventHandler<ActionEvent> {

    private MainFrame mainFrame;
    private GameEngine gameEngine;
    private BoardManager boardManager;

    public static int moveCount = 1;

    public NavigationPanelController(MainFrame mainFrame, GameEngine gameEngine, BoardManager boardManager){
        this.mainFrame = mainFrame;
        this.gameEngine = gameEngine;
        this.boardManager = boardManager;
    }

    @Override
    public void handle(ActionEvent event) {
        Button b = (Button) event.getSource();
        String txt = b.getText();
        switch(txt){
            case "Neste":
                nextMove();
                break;
            case "Forrige":
                previousMove();
                break;
            case "Auto":
                autoPlay();
                break;
        }
    }

    private void nextMove(){
        FinalChessObject c = (FinalChessObject)mainFrame.getDisplayPanel().getMatches().getSelectionModel().getSelectedItem();
        TreeMap<Integer, MoveDescriptionObject> moves = c.getMoves();
        try {
            boardManager.findPiece(moves.get(moveCount).getMove());
        }catch (NullPointerException e){
            System.out.print("Ingen flere trekk");
        }
        moveCount++;
    }

    private void previousMove(){

    }

    private void autoPlay(){

    }
}

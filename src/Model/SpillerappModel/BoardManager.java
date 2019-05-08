package Model.SpillerappModel;


import Model.AdmappModel.MoveDescriptionObject;
import Model.SpillerappModel.Interface.GameEngine;
import View.SpillerappView.ChessPanel;
import View.SpillerappView.MainFrame;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.TreeMap;

public class BoardManager implements GameEngine {

    private ArrayList<ChessCell> chessCells;

   // private final String k;

    public BoardManager(MainFrame mainFrame){

        chessCells = new ArrayList<>();
        ChessCell cell;
        int colorCount = 1;
        int iterate = 0;
        for(int i = 0; i<8; i++) {
            for (int j = 0; j <8; j++) {
                mainFrame.getChessPanel().add(cell = new ChessCell(colorCount%2, ChessPanel.chessPositions[iterate]), i, j);
                chessCells.add(cell);
                colorCount++;
                iterate++;
                //System.out.println(cell.getBoundsInLocal());
            }
            colorCount++;
        }
    }

    @Override
    public void movePiece(String move){
    /*
    Først finn ut hvilken brikke trekket gjelder
    sjekk moven opp mot alle mulige plasser tabellen. Om den blir funnet,
     */
    }

    public ArrayList<ChessCell> getChessCells() {
        return chessCells;
    }
}

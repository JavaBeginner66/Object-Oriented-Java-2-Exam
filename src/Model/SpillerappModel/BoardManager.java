package Model.SpillerappModel;


import View.SpillerappView.ChessPanel;
import View.SpillerappView.MainFrame;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class BoardManager {

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
        addBoardPieces();
    }

    private void addBoardPieces(){

    }

    public ArrayList<ChessCell> getChessCells() {
        return chessCells;
    }
}

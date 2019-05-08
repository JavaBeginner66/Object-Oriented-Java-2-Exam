package Model.SpillerappModel;


import Model.AdmappModel.MoveDescriptionObject;
import Model.SpillerappModel.Interface.GameEngine;
import View.SpillerappView.ChessPanel;
import View.SpillerappView.MainFrame;
import View.SpillerappView.Observer.CallbackGUI;
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
        System.out.print("yo");
        if(true) {

            //if WHITE_TURN
            if (Character.isUpperCase(move.charAt(0))) {
                // Brikken er ikke en bonde


            } else if (move.length() == 2) {
                // Bonde beveger seg skrått (Her kan programmet finne 2 bønder?)
                // Sjekk forrige trekk fra samme brikken?

            } else {
                //gå gjennom alle bønder som har en valid posisjon
                for (int i = 0; i < chessCells.size(); i++) {
                    int number = chessCells.get(i).getPosition().charAt(1);
                    char letter = chessCells.get(i).getPosition().charAt(0);
                    number++;
                    String newMove = letter + number + "";
                    if (move.equals(newMove)) {
                        // Bonde funnet
                        movePiece(chessCells.get(i).getPosition(), move);
                    }
                }
            }
        }
    /*
    Først finn ut hvilken brikke trekket gjelder
    sjekk moven opp mot alle mulige plasser tabellen. Om den blir funnet,
     */
    }

    public ArrayList<ChessCell> getChessCells() {
        return chessCells;
    }
}

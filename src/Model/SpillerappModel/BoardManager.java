package Model.SpillerappModel;


import Controller.SpillerappController.NavigationPanelController;
import View.SpillerappView.ChessPanel;
import View.SpillerappView.MainFrame;

import java.util.ArrayList;

/**
 * Klassen har ansvar for å lage og kontrollere
 * sjakkbordet
 */

public class BoardManager extends JointClass {

    private ArrayList<ChessCell> chessCells;

    private MainFrame mainFrame;

    public BoardManager(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    @Override
    public void createBoard(){
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
    public void findPiece(String move){

        if(NavigationPanelController.playerTurn == 1) {
            if (Character.isUpperCase(move.charAt(0))) {
                // Brikken er ikke en bonde

            } else if (move.length() == 3) {
                // Bonde beveger seg skrått (Her kan programmet finne 2 bønder?)
                // Sjekk forrige trekk fra samme brikken?
            } else {
                for (int i = 0; i < chessCells.size(); i++) {
                    int number = chessCells.get(i).getPosition().charAt(1);
                    char letter = chessCells.get(i).getPosition().charAt(0);
                    number++;
                    char newNumber = (char)number;
                    String newMove =  "" + letter + newNumber;
                    if (move.equals(newMove)) {
                        // Bonde funnet
                        movePiece(i, chessCells.get(i).getPosition(), move);
                    }
                }
            }
        }else{
            if (Character.isUpperCase(move.charAt(0))) {
                // Brikken er ikke en bonde

            } else if (move.length() == 3) {
                // Bonde beveger seg skrått (Her kan programmet finne 2 bønder?)
                // Sjekk forrige trekk fra samme brikken?
            } else {

                //gå gjennom alle bønder som har en valid posisjon
                for (int i = 0; i < chessCells.size(); i++) {
                    int number = chessCells.get(i).getPosition().charAt(1);
                    char letter = chessCells.get(i).getPosition().charAt(0);
                    number--;
                    char newNumber = (char)number;
                    String newMove =  "" + letter + newNumber;
                    //System.out.println(move + " " + newMove);
                    if (move.equals(newMove)) {

                        // Bonde funnet
                        movePiece(i, chessCells.get(i).getPosition(), move);
                    }
                }
            }
        }
    }

    @Override
    public void movePiece(int cell, String oldPosition, String newPosition) {
        System.out.println("Moving piece from " + oldPosition + " to " + newPosition);
        chessCells.get(cell).removePiece();
        if (NavigationPanelController.playerTurn == 1) {
            for (int i = 0; i < chessCells.size(); i++) {
                if (chessCells.get(i).getPosition().equals(newPosition)) {
                    chessCells.get(i).addPiece(newPosition, "Brikker/Hvit_Bonde.png");
                }
            }
        } else {
            for (int i = 0; i < chessCells.size(); i++) {
                if (chessCells.get(i).getPosition().equals(newPosition)) {
                    chessCells.get(i).addPiece(newPosition, "Brikker/Svart_Bonde.png");
                }
            }
        }
    }

    public ArrayList<ChessCell> getChessCells() {
        return chessCells;
    }
}

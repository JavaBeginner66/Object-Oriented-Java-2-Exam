package Model.SpillerappModel.Interface;

import Model.AdmappModel.MoveDescriptionObject;

import java.util.TreeMap;

public interface GameEngine {
    /**
     * Flytter en brikke til en ny ChessCell
     */
    public void movePiece(String move);
}

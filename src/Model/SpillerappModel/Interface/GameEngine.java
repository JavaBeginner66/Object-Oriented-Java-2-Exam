package Model.SpillerappModel.Interface;

import Model.AdmappModel.MoveDescriptionObject;

import java.util.TreeMap;

/**
 * Interfacen blir implementert hovedsakelig
 * av BoardManager
 */

public interface GameEngine {
    /**
     * Flytter en brikke til en ny ChessCell
     */
    public void findPiece(String move);

    /**
     * Lager sjakkbrettet
     */
    public void createBoard();

    /**
     * Flytter en brikke til ny posisjon
     */
    public void movePiece(int cell, String oldPosition, String newPosition);
}

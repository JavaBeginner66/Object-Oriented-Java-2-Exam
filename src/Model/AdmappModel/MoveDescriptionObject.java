package Model.AdmappModel;

import java.io.Serializable;

/**
 * Klassen lagrer hvilket trekk som er tatt i tilleg til kvalitetskommentar
 * i form av to tegn.
 * Implementerer Serializable for å kunne bli
 * skrevet inn/ut av fil som objekt
 */

public class MoveDescriptionObject implements Serializable {


    private static final long serialVersionUID = -5254071801993844870L;
    private String move;
    private String moveComment;

    public MoveDescriptionObject(String move, String moveComment){
        this.move = move;
        this.moveComment = moveComment;
    }

    @Override
    public String toString() {
        return "Trekk: " + move + " Kommentar: " + moveComment;
    }

    /* Get methods */

    public String getMove() {
        return move;
    }

    public String getMoveComment() {
        return moveComment;
    }
}

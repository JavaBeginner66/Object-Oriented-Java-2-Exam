package Model.AdmappModel;

import java.io.Serializable;

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

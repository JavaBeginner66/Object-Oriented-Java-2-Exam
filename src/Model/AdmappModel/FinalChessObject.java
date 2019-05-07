package Model.AdmappModel;

import java.io.Serializable;
import java.util.TreeMap;

public class FinalChessObject implements Serializable {

    private static final long serialVersionUID = 7524854553255443349L;

    private MatchResult matchResult;
    private TreeMap<String, MoveDescriptionObject> moves;

    public FinalChessObject(MatchResult result, TreeMap<String, MoveDescriptionObject> moves){
        this.matchResult = result;
        this.moves = moves;
    }

    @Override
    public String toString() {
        return matchResult + "";
    }

    /* Get methods */

    public MatchResult getMatchResult() {
        return matchResult;
    }

    public TreeMap<String, MoveDescriptionObject> getMoves() {
        return moves;
    }
}

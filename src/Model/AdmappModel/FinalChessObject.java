package Model.AdmappModel;

import java.io.Serializable;
import java.util.TreeMap;

/**
 * Klassen lagrer info om det endelige objektet.
 * Implementerer Serializable for å kunne bli
 * skrevet inn/ut av fil som objekt
 *
 * Klassen inneholder to andre store objekt som har
 * ytterligere opplysninger om partiet
 */

public class FinalChessObject implements Serializable {

    private static final long serialVersionUID = 7524854553255443349L;

    private MatchResult matchResult;
    private TreeMap<Integer, MoveDescriptionObject> moves;

    public FinalChessObject(MatchResult result, TreeMap<Integer, MoveDescriptionObject> moves){
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

    public TreeMap<Integer, MoveDescriptionObject> getMoves() {
        return moves;
    }
}

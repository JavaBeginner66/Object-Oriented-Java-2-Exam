package View.SpillerappView;

import Model.SpillerappModel.Interface.GameEngine;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

import java.util.TreeMap;

/**
 * Panel-klasse som har ansvar for å holde på sjakkbrett komponenter
 */

public class ChessPanel extends GridPane {

    public static final String[] chessPositions = {"a8", "a7", "a6", "a5", "a4", "a3", "a2", "a1",
            "b8", "b7", "b6", "b5", "b4", "b3", "b2", "b1",
            "c8", "c7", "c6", "c5", "c4", "c3", "c2", "c1",
            "d8", "d7", "d6", "d5", "d4", "d3", "d2", "d1",
            "e8", "e7", "e6", "e5", "e4", "e3", "e2", "e1",
            "f8", "f7", "f6", "f5", "f4", "f3", "f2", "f1",
            "g8", "g7", "g6", "g5", "g4", "g3", "g2", "g1",
            "h8", "h7", "h6", "h5", "h4", "h3", "h2", "h1"};

    public static final TreeMap<String, String> pieces = new TreeMap<String, String>(){{
        put("Hvit_Bonde", "/Brikker/Hvit_Bonde.png");
        put("Svart_Bonde", "/Brikker/Svart_Bonde.png");
        put("Hvit_Hest", "/Brikker/Hvit_Hest.png");
        put("Svart_Hest", "/Brikker/Svart_Hest.png");
        put("Hvit_Dronning", "/Brikker/Hvit_Dronning.png");
        put("Svart_Dronning", "/Brikker/Svart_Dronning.png");
        put("Hvit_Konge", "/Brikker/Hvit_Konge.png");
        put("Svart_Konge", "/Brikker/Svart_Konge.png");
        put("Hvit_Loper", "/Brikker/Hvit_Loper.png");
        put("Svart_Loper", "/Brikker/Svart_Loper.png");
        put("Hvit_Torn", "/Brikker/Hvit_Torn.png");
        put("Svart_Torn", "/Brikker/Svart_Torn.png");
    }};

    public ChessPanel(){
        this.getStyleClass().add("chessPanel");
    }

    public void addListeners(MainFrame mainFrame, GameEngine gameEngine){

    }
}

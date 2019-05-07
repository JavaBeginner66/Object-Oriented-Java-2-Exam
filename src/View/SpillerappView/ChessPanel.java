package View.SpillerappView;

import Model.SpillerappModel.Interface.GameEngine;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

import java.util.TreeMap;

public class ChessPanel extends GridPane {

    public static final String[] chessPositions = {"A8", "A7", "A6", "A5", "A4", "A3", "A2", "A1",
            "B8", "B7", "B6", "B5", "B4", "B3", "B2", "B1",
            "C8", "C7", "C6", "C5", "C4", "C3", "C2", "C1",
            "D8", "D7", "D6", "D5", "D4", "D3", "D2", "D1",
            "E8", "E7", "E6", "E5", "E4", "E3", "E2", "E1",
            "F8", "F7", "F6", "F5", "F4", "F3", "F2", "F1",
            "G8", "G7", "G6", "G5", "G4", "G3", "G2", "G1",
            "H8", "H7", "H6", "H5", "H4", "H3", "H2", "H1"};

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
        this.setPadding(new Insets(10,10,10,10));


    }

    public void addListeners(MainFrame mainFrame, GameEngine gameEngine){

    }
}

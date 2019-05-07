package View.SpillerappView;

import Model.SpillerappModel.Interface.GameEngine;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class ChessPanel extends GridPane {

    public ChessPanel(){
        this.setPadding(new Insets(10,10,10,10));
    }

    public void addListeners(MainFrame mainFrame, GameEngine gameEngine){

    }
}

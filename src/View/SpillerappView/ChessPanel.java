package View.SpillerappView;

import Model.SpillerappModel.Interface.GameEngine;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;

public class ChessPanel extends Pane {

    public ChessPanel(){
        this.setStyle("-fx-background-color: #a1edb0;");
        this.setPadding(new Insets(10,10,10,580));
    }

    public void addListeners(MainFrame mainFrame, GameEngine gameEngine){

    }
}

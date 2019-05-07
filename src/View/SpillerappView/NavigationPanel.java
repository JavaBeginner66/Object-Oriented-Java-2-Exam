package View.SpillerappView;

import Model.SpillerappModel.Interface.GameEngine;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class NavigationPanel extends HBox {

    private Button autoMove;
    private Button previous;
    private Button next;


    public NavigationPanel(){
        this.setStyle("-fx-background-color: #c4c4c4;");
        this.setPadding(new Insets(10,10,10,580));
        this.setSpacing(30);

        componentSetup();
    }

    private void componentSetup(){
        autoMove = new Button("Auto");
        previous = new Button("Forje");
        next = new Button("Neste");

        this.getChildren().addAll(previous, autoMove, next);
    }

    public void addListeners(MainFrame mainFrame, GameEngine gameEngine){

    }

    /* Get methods */

    public Button getAutoMove() {
        return autoMove;
    }

    public Button getPrevious() {
        return previous;
    }

    public Button getNext() {
        return next;
    }
}

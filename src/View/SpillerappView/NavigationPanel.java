package View.SpillerappView;

import Controller.SpillerappController.NavigationPanelController;
import Model.SpillerappModel.BoardManager;
import Model.SpillerappModel.Interface.GameEngine;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class NavigationPanel extends HBox {

    private Button autoMove;
    private Button previous;
    private Button next;


    public NavigationPanel(){
        this.getStyleClass().add("navPanel");
        this.setSpacing(30);

        componentSetup();
    }

    private void componentSetup(){
        autoMove = new Button("Auto");
        previous = new Button("Forrige");
        next = new Button("Neste");

        this.getChildren().addAll(previous, autoMove, next);
    }

    public void addListeners(MainFrame mainFrame, GameEngine gameEngine, BoardManager boardManager){
        NavigationPanelController listener = new NavigationPanelController(mainFrame, gameEngine, boardManager);
        autoMove.setOnAction(listener);
        previous.setOnAction(listener);
        next.setOnAction(listener);
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

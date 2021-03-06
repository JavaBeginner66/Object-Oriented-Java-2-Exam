package View.SpillerappView;

import Model.SpillerappModel.BoardManager;
import Model.SpillerappModel.Interface.GameEngine;
import javafx.scene.layout.BorderPane;

/**
 * Hoved panel-klasse som har ansvar for å
 * initialisere alle andre panel
 * Blir også brukt som en referanse for å sende listeners videre
 */

public class MainFrame extends BorderPane {

    private final DisplayPanel displayPanel;
    private final NavigationPanel navigationPanel;
    private final ChessPanel chessPanel;

    public MainFrame(){
        this.setLeft(displayPanel = new DisplayPanel());
        this.setBottom(navigationPanel = new NavigationPanel());
        this.setCenter(chessPanel = new ChessPanel());
    }

    public void addListeners(GameEngine engine, BoardManager boardManager){
        displayPanel.addListeners(this, engine, boardManager);
        navigationPanel.addListeners(this, engine, boardManager);
    }

    /* Get methods */

    public DisplayPanel getDisplayPanel() {
        return displayPanel;
    }

    public NavigationPanel getNavigationPanel() {
        return navigationPanel;
    }

    public ChessPanel getChessPanel() {
        return chessPanel;
    }
}

package View.SpillerappView;

import Controller.SpillerappController.DisplayPanelController;
import Controller.SpillerappController.ListViewController;
import Model.AdmappModel.FinalChessObject;
import Model.SpillerappModel.BoardManager;
import Model.SpillerappModel.Interface.GameEngine;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;


public class DisplayPanel extends VBox {

    private Button rank;
    private TextField searchArea;
    private Button search;
    private ListView<FinalChessObject> matches;
    private TextArea movesDescription;

    public DisplayPanel(){
        this.getStyleClass().add("displayPanel");
        this.setSpacing(10);

        componentSetup();
    }

    private void componentSetup(){
        HBox searchField = new HBox();

        rank = new Button("Rangering");
        searchArea = new TextField();
        search = new Button("Søk etter person");
        searchField.getChildren().addAll(searchArea, search);
        matches = new ListView<FinalChessObject>();
        movesDescription = new TextArea();
        ScrollPane matchesView = new ScrollPane(matches);
        ScrollPane movesView = new ScrollPane(movesDescription);

        searchField.setSpacing(10);
        searchArea.setMinWidth(230);
        matches.setMinWidth(350);
        movesView.setMaxWidth(350);



        this.getChildren().addAll(rank, searchField, matchesView, movesView);
    }

    public void addListeners(MainFrame mainFrame, GameEngine gameEngine, BoardManager boardManager){
        DisplayPanelController listener = new DisplayPanelController(mainFrame, gameEngine);
        ListViewController listener2 = new ListViewController(mainFrame, boardManager);
        rank.setOnAction(listener);
        search.setOnAction(listener);
        matches.setOnMouseClicked(listener2);
    }

    /* Get methods */

    public Button getRank() {
        return rank;
    }

    public TextField getSearchArea() {
        return searchArea;
    }

    public Button getSearch() {
        return search;
    }

    public ListView getMatches() {
        return matches;
    }

    public TextArea getMovesDescription() {
        return movesDescription;
    }
}

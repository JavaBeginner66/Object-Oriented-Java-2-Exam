package View.SpillerappView;

import Controller.SpillerappController.DisplayPanelController;
import Model.AdmappModel.FinalChessObject;
import Model.SpillerappModel.Interface.GameEngine;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class DisplayPanel extends VBox {

    private Button rank;
    private TextField searchArea;
    private Button search;
    private ListView<FinalChessObject> matches;
    private TextArea movesDescription;

    public DisplayPanel(){
        this.setStyle("-fx-background-color: #c4c4c4;");
        this.setPadding(new Insets(10,10,10,10));
        this.setSpacing(10);

        componentSetup();
    }

    private void componentSetup(){
        GridPane searchField = new GridPane();

        rank = new Button("Rankering");
        searchField.add(searchArea = new TextField(), 0,0);
        searchField.add(search = new Button("Søk etter parti"), 1,0);
        matches = new ListView<FinalChessObject>();
        movesDescription = new TextArea();
        ScrollPane matchesView = new ScrollPane(matches);
        ScrollPane movesView = new ScrollPane(movesDescription);

        matchesView.setMaxWidth(260);
        movesView.setMaxWidth(260);



        this.getChildren().addAll(rank, searchField, matchesView, movesView);
    }

    public void addListeners(MainFrame mainFrame, GameEngine gameEngine){
        DisplayPanelController listener = new DisplayPanelController(mainFrame, gameEngine);
        rank.setOnAction(listener);
        search.setOnAction(listener);
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

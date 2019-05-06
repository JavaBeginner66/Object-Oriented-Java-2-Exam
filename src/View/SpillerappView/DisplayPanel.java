package View.SpillerappView;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class DisplayPanel extends VBox {

    private Button rank;
    private TextField searchArea;
    private Button search;
    private ListView matches;
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
        searchField.add(search = new Button("Søk"), 1,0);
        matches = new ListView();
        movesDescription = new TextArea();
        ScrollPane matchesView = new ScrollPane(matches);
        ScrollPane movesView = new ScrollPane(movesDescription);

        matchesView.setMaxWidth(260);
        movesView.setMaxWidth(260);



        this.getChildren().addAll(rank, searchField, matchesView, movesView );
    }
}

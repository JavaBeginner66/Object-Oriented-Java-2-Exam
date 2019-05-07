package Model.SpillerappModel;


import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ChessCell extends Pane {

    private String position;

    /**
     * @param id
     *      Om id er 1, er panelet hvitt, 0 om grått
     */
    public ChessCell(int id, String position){
        this.position = position;
        setup(id);

    }

    private void setup(int id){
        if(id == 1){
            this.setStyle("-fx-background-color: #d6d9db;");
        }else{
            this.setStyle("-fx-background-color: #606060;");
        }
        this.setPadding(new Insets(30,30,30,30));
        this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.setMinSize(80, 80);

        this.getChildren().addAll(new Label(position));
    }
}

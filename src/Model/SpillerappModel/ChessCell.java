package Model.SpillerappModel;


import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ChessCell extends Pane {

    public ChessCell(){
        this.setStyle("-fx-background-color: #8211dd;");
        this.setPadding(new Insets(30,30,30,30));
        this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.setMinSize(80, 80);
    }
}

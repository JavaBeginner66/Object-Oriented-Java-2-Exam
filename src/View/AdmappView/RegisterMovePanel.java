package View.AdmappView;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

import java.awt.*;

public class RegisterMovePanel extends HBox {

    public RegisterMovePanel(){
        this.setStyle("-fx-background-color: #eddd0a;");
        this.setPadding(new Insets(10,10,10,10));
        this.setSpacing(10);

        componentSetup();
    }

    private void componentSetup(){
        Label registerMoveLabel = new Label("Registrer trekk");
    }
}

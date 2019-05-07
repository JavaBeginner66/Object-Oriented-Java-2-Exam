package Model.SpillerappModel;


import View.SpillerappView.ChessPanel;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class ChessCell extends StackPane {

    private String position;
    private ImageView piece;

    /**
     * @param id
     *      Om id er 1, er panelet hvitt, 0 om grått
     */
    public ChessCell(int id, String position){
        this.position = position;
        setup(id);
        pieceSetup();

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

    }

    public void addPiece(String img){
        //this.getChildren().removeAll(piece);
        piece = new ImageView( new Image(img));
        this.getChildren().addAll(piece);
    }

    private void pieceSetup(){
        switch(position){
            case "A2": case "B2":case "C2": case "D2":case "E2": case "F2":case "G2": case "H2":
                addPiece(ChessPanel.pieces.get("Hvit_Bonde"));
                break;
            case "A7": case "B7":case "C7": case "D7":case "E7": case "F7":case "G7": case "H7":
                addPiece(ChessPanel.pieces.get("Svart_Bonde"));
                break;
            case "A1": case"H1":
                addPiece(ChessPanel.pieces.get("Hvit_Torn"));
                break;
            case "A8": case"H8":
                addPiece(ChessPanel.pieces.get("Svart_Torn"));
                break;
            case "B1": case"G1":
                addPiece(ChessPanel.pieces.get("Hvit_Hest"));
                break;
            case "B8": case"G8":
                addPiece(ChessPanel.pieces.get("Svart_Hest"));
                break;
            case "C1": case"F1":
                addPiece(ChessPanel.pieces.get("Hvit_Loper"));
                break;
            case "C8": case"F8":
                addPiece(ChessPanel.pieces.get("Svart_Loper"));
                break;
            case "D1":
                addPiece(ChessPanel.pieces.get("Hvit_Konge"));
                break;
            case "D8":
                addPiece(ChessPanel.pieces.get("Svart_Konge"));
                break;
            case "E1":
                addPiece(ChessPanel.pieces.get("Hvit_Dronning"));
                break;
            case "E8":
                addPiece(ChessPanel.pieces.get("Svart_Dronning"));
                break;
        }
    }
}

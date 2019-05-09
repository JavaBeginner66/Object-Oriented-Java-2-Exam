package Model.SpillerappModel;


import View.SpillerappView.ChessPanel;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * Klassen er tatt i bruk som ett sjakk felt.
 * Blir initialisert 8*8 ganger av BoardManager.
 */

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

    /**
     * Metoden legger til brikker på bordet (startfasen)
     */
    public void addPiecesToBoard(String img){
        piece = new ImageView( new Image(img));
        this.getChildren().addAll(piece);
    }

    /**
     * Metoden gir objektet en ny posisjon, og legger til nytt bilde
     */
    public void addPiece(String newPosition, String img){
        this.position = newPosition;
        piece = new ImageView( new Image(img));
        this.getChildren().addAll(piece);
    }

    /**
     * Metoden fjerner brikke(Imageview) fra brettet
     */
    public void removePiece(){
        this.getChildren().clear();
    }


    /**
     * Standard startfase setup av alle brikker
     */
    private void pieceSetup(){
        switch(position){
            case "a2": case "b2":case "c2": case "d2":case "e2": case "f2":case "g2": case "h2":
                addPiecesToBoard(ChessPanel.pieces.get("Hvit_Bonde"));
                break;
            case "a7": case "b7":case "c7": case "d7":case "e7": case "f7":case "g7": case "h7":
                addPiecesToBoard(ChessPanel.pieces.get("Svart_Bonde"));
                break;
            case "a1": case"h1":
                addPiecesToBoard(ChessPanel.pieces.get("Hvit_Torn"));
                break;
            case "a8": case"h8":
                addPiecesToBoard(ChessPanel.pieces.get("Svart_Torn"));
                break;
            case "b1": case"g1":
                addPiecesToBoard(ChessPanel.pieces.get("Hvit_Hest"));
                break;
            case "b8": case"g8":
                addPiecesToBoard(ChessPanel.pieces.get("Svart_Hest"));
                break;
            case "c1": case"f1":
                addPiecesToBoard(ChessPanel.pieces.get("Hvit_Loper"));
                break;
            case "c8": case"f8":
                addPiecesToBoard(ChessPanel.pieces.get("Svart_Loper"));
                break;
            case "d1":
                addPiecesToBoard(ChessPanel.pieces.get("Hvit_Konge"));
                break;
            case "d8":
                addPiecesToBoard(ChessPanel.pieces.get("Svart_Konge"));
                break;
            case "e1":
                addPiecesToBoard(ChessPanel.pieces.get("Hvit_Dronning"));
                break;
            case "e8":
                addPiecesToBoard(ChessPanel.pieces.get("Svart_Dronning"));
                break;
        }
    }

    public String getPosition() {
        return position;
    }

    public ImageView getPiece() {
        return piece;
    }
}

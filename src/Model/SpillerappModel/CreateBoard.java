package Model.SpillerappModel;


import View.SpillerappView.MainFrame;
import javafx.scene.control.Button;

public class CreateBoard {

    public CreateBoard(MainFrame mainFrame){
        ChessCell cell;
        for(int i = 0; i<8; i++) {
            for (int j = 0; j <8; j++) {
                mainFrame.getChessPanel().add(cell = new ChessCell(), i, j);
            }
        }
    }
}

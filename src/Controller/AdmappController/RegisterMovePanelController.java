package Controller.AdmappController;

import View.AdmappView.MainFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class RegisterMovePanelController implements EventHandler<ActionEvent> {

    private MainFrame mainFrame;

    public RegisterMovePanelController(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    @Override
    public void handle(ActionEvent event) {
        Button b = (Button) event.getSource();
        String s = b.getText();
        switch (s){
            case "Lagre Trekk":
                saveMove();
                break;
            case "Lagre Data":
                saveMatchObject();
                break;
        }
    }

    private void saveMove(){

    }

    private void saveMatchObject(){
        
    }

}

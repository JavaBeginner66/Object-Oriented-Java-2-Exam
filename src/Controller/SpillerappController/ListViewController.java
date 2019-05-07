package Controller.SpillerappController;

import View.SpillerappView.MainFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ListViewController implements EventHandler<MouseEvent> {

    private MainFrame mainFrame;

    public ListViewController(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    @Override
    public void handle(MouseEvent event) {
        System.out.print(mainFrame.getDisplayPanel().getMatches().getSelectionModel().getSelectedItem());
    }
}

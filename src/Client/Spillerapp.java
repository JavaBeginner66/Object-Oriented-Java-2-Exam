package Client;

import Model.SpillerappModel.GameEngineImpl;
import Model.SpillerappModel.Interface.GameEngine;
import View.SpillerappView.MainFrame;
import View.SpillerappView.Observer.CallbackGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Spillerapp extends Application {

    @Override
    public void start(Stage stage) {

        /* View */
        final MainFrame mainFrame = new MainFrame();
        /* Model and GUI callback*/
        final GameEngine gameEngine = new GameEngineImpl(new CallbackGUI(mainFrame));
        /* Listeners */
        mainFrame.addListeners(gameEngine);


        Scene scene = new Scene(mainFrame, 1000, 800);
        stage.setTitle("Spillerapp");
        stage.setScene(scene);
        stage.show();

    }
}

package Client;


import Model.AdmappModel.EngineImpl;
import Model.AdmappModel.Interface.Engine;
import View.AdmappView.MainFrame;
import View.AdmappView.Observer.CallbackGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Admapp extends Application {
    @Override
    public void start(Stage stage) {

        /* View */
        final MainFrame mainFrame = new MainFrame();
        /* Model and GUI callback*/
        final Engine engine = new EngineImpl(new CallbackGUI(mainFrame));
        /* Listeners */
        mainFrame.addListeners(engine);


        Scene scene = new Scene(mainFrame, 1000, 400);
        stage.setTitle("Admapp");
        stage.setScene(scene);
        stage.show();

    }
}
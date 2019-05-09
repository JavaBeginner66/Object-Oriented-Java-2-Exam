package Client;


import Model.AdmappModel.EngineImpl;
import Model.AdmappModel.FinalChessObject;
import Model.AdmappModel.Interface.Engine;
import View.AdmappView.MainFrame;
import View.AdmappView.Observer.CallbackGUI;
import View.AdmappView.RegisterMatchPanel;
import View.AdmappView.RegisterMovePanel;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Programmet registrer deltakere, parti, resultater og trekk,
 * og legger de inn på filer som objekter.
 * Klassen starter og legger ut referanser for applikasjonen
 *
 * @version 1.0
 *  * @since 0.9.05.2019
 */


public class Admapp extends Application {

    @Override
    public void start(Stage stage) {

        /* View */
        final MainFrame mainFrame = new MainFrame();
        /* Model and GUI callback*/
        final Engine engine = new EngineImpl(new CallbackGUI(mainFrame));
        /* Listeners (EventHandlers)*/
        mainFrame.addListeners(engine);


        Scene scene = new Scene(mainFrame, 950, 370);
        scene.getStylesheets().add("CSS/Admapp.css");
        stage.setTitle("Admapp");
        stage.setScene(scene);
        stage.show();

        mainFrame.createCopyFile(stage);
    }
}
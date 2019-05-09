package Client;

import Model.SpillerappModel.BoardManager;
import Model.SpillerappModel.JointClass;
import Model.SpillerappModel.Interface.GameEngine;
import View.SpillerappView.MainFrame;
import View.SpillerappView.Observer.CallbackGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Programmet leser inn objekter fra fil med deltakere,
 * parti, resultat og trekk som er registrert via admapp applikasjonen.
 * Bruker kan se en rangering, en liste over parti spilt, og hvilke trekk som
 * er tatt i en numerert liste. Bruker skal også i beste fall
 * få opp et sjakkbrett og kunne navigere gjennom trekka.
 *
 * Klassen starter og legger ut referanser for applikasjonen
 *
 * @version 1.0
 *  * @since 0.9.05.2019
 */

public class Spillerapp extends Application {

    @Override
    public void start(Stage stage) {

        /* View */
        final MainFrame mainFrame = new MainFrame();
        /* Model and GUI callback*/
        final GameEngine gameEngine = new JointClass(new CallbackGUI(mainFrame));
        /* Listeners (EventHandlers)*/
        mainFrame.addListeners(gameEngine, new BoardManager(mainFrame));


        Scene scene = new Scene(mainFrame, 1030, 700);
        scene.getStylesheets().add("CSS/Spillerapp.css");
        stage.setTitle("Spillerapp");
        stage.setScene(scene);
        stage.show();

    }
}

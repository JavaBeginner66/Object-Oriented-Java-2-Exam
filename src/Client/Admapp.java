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
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.*;
import java.util.ArrayList;

public class Admapp extends Application {

    private static final String KOPI_FIL = "sikkerhetskopi.rtf";

    @Override
    public void start(Stage stage) {

        /* View */
        final MainFrame mainFrame = new MainFrame();
        /* Model and GUI callback*/
        final Engine engine = new EngineImpl(new CallbackGUI(mainFrame));
        /* Listeners */
        mainFrame.addListeners(engine);


        Scene scene = new Scene(mainFrame, 950, 370);
        scene.getStylesheets().add("CSS/Admapp.css");
        stage.setTitle("Admapp");
        stage.setScene(scene);
        stage.show();


        /* Sikkerhetskopi */
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                if(RegisterMovePanel.matchOverview.exists()){
                    ArrayList<FinalChessObject> chessObjects = new ArrayList<>();
                    try{
                        FileInputStream f = new FileInputStream(RegisterMovePanel.matchOverview);
                        try{
                            for(;;) {
                                try {
                                    ObjectInputStream fromFile = new ObjectInputStream(f);
                                    chessObjects.add((FinalChessObject)fromFile.readObject());
                                } catch (ClassNotFoundException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        }catch(EOFException eof){
                            f.close();
                        }
                    }catch(IOException io){
                        io.printStackTrace();
                    }
                    try {
                        PrintWriter toCopyFile = new PrintWriter(KOPI_FIL);

                        toCopyFile.write("Parti oversikt: ");
                        for(int i = 0; i<chessObjects.size(); i++) {
                            toCopyFile.write("\n" + chessObjects.get(i).toString());
                            for (int j = 1; j <= chessObjects.get(i).getMoves().size(); j++) {
                                toCopyFile.write("\n" + j + " " +  chessObjects.get(i).getMoves().get(j));
                            }
                        }

                        toCopyFile.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }
}
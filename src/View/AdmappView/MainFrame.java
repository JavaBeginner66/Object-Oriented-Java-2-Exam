package View.AdmappView;


import Controller.SpillerappController.DisplayPanelController;
import Model.AdmappModel.FinalChessObject;
import Model.AdmappModel.Interface.Engine;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.*;
import java.util.ArrayList;

public class MainFrame extends GridPane {

    private static final String KOPI_FIL = "sikkerhetskopi.rtf";

    private final RegisterPlayerPanel registerPlayerPanel;
    private final RegisterMatchPanel registerMatchPanel;
    private final ResultPanel resultPanel;
    private final RegisterMovePanel registerMovePanel;

    public MainFrame(){
        this.setPadding(new Insets(10));
        this.setHgap(10);

        this.add(registerPlayerPanel = new RegisterPlayerPanel(), 0,0);
        this.add(registerMatchPanel = new RegisterMatchPanel(), 1,0);
        this.add(resultPanel = new ResultPanel(), 2,0);
        this.add(registerMovePanel = new RegisterMovePanel(), 3,0);

    }

    public void addListeners(Engine engine){
        registerPlayerPanel.addListeners(this, engine);
        registerMatchPanel.addListeners(this, engine);
        registerMovePanel.addListeners(this, engine);
        resultPanel.addListeners(this, engine);
    }

    public void createCopyFile(Stage stage){
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

                        toCopyFile.write("Registrerte parti: ");
                        for (int g = 0; g < chessObjects.size(); g++) {
                            toCopyFile.write("\n" + chessObjects.get(g).getMatchResult().getMatchInfo());
                        }
                        toCopyFile.write("\n Spilte parti oversikt: ");
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

    /* Get methods */

    public RegisterPlayerPanel getRegisterPlayerPanel() {
        return registerPlayerPanel;
    }

    public RegisterMatchPanel getRegisterMatchPanel() {
        return registerMatchPanel;
    }

    public ResultPanel getResultPanel() {
        return resultPanel;
    }

    public RegisterMovePanel getRegisterMovePanel() {
        return registerMovePanel;
    }
}

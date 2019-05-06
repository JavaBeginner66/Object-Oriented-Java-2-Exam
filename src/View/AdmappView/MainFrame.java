package View.AdmappView;


import Model.AdmappModel.Interface.Engine;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class MainFrame extends GridPane {

    private RegisterPlayerPanel registerPlayerPanel;
    private RegisterMatchPanel registerMatchPanel;
    private ResultPanel resultPanel;
    private RegisterMovePanel registerMovePanel;

    private Button saveData;

    public MainFrame(){
        this.setPadding(new Insets(20,20,20,20));
        this.setVgap(20);

        this.add(registerPlayerPanel = new RegisterPlayerPanel(), 0,0);
        this.add(registerMatchPanel = new RegisterMatchPanel(), 0,1);
        this.add(resultPanel = new ResultPanel(), 0,2);
        this.add(registerMovePanel = new RegisterMovePanel(), 0,3);

        this.add(saveData = new Button("Lagre Data"), 0, 4);
    }

    public void addListeners(Engine engine){
        registerPlayerPanel.addListeners(this, engine);
        registerMatchPanel.addListeners(this, engine);
        registerMovePanel.addListeners(this, engine);
        resultPanel.addListeners(this, engine);
    }

    /* Get methods */

    public Button getSaveData() {
        return saveData;
    }
}

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

package Model.AdmappModel;

import Model.AdmappModel.Interface.Engine;
import View.AdmappView.Observer.CallbackGUI;

public class EngineImpl implements Engine {

    private CallbackGUI callbackGUI;

    public EngineImpl(CallbackGUI callbackGUI){
        this.callbackGUI = callbackGUI;
    }
}

package Model.SpillerappModel;

import Model.SpillerappModel.Interface.GameEngine;
import View.SpillerappView.Observer.CallbackGUI;

public class GameEngineImpl implements GameEngine {

    private CallbackGUI callbackGUI;

    public GameEngineImpl(CallbackGUI callbackGUI){
        this.callbackGUI = callbackGUI;
    }
}

package Model.SpillerappModel;

import Model.AdmappModel.MoveDescriptionObject;
import Model.SpillerappModel.Interface.GameEngine;
import View.SpillerappView.Observer.CallbackGUI;

import java.util.TreeMap;

public class GameEngineImpl implements GameEngine {

    private CallbackGUI callbackGUI;

    public GameEngineImpl(CallbackGUI callbackGUI){
        this.callbackGUI = callbackGUI;
    }

    @Override
    public void movePiece(String move) {

    }
}

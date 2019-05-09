package Model.SpillerappModel;

import Model.AdmappModel.MoveDescriptionObject;
import Model.SpillerappModel.Interface.GameEngine;
import View.SpillerappView.Observer.CallbackGUI;

import java.util.TreeMap;

public class JointClass implements GameEngine{

    private CallbackGUI callbackGUI;

    public JointClass(CallbackGUI callbackGUI){
        this.callbackGUI = callbackGUI;
    }
     public JointClass(){

     }

    @Override
    public void findPiece(String move) { }

    @Override
    public void createBoard() { }

    @Override
    public void movePiece(int cell, String oldPosition, String newPosition) { }
}

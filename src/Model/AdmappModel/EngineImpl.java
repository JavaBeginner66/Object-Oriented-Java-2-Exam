package Model.AdmappModel;

import Model.AdmappModel.Interface.Engine;
import View.AdmappView.Observer.CallbackGUI;

/**
 * Referanse-objekt
 * (I utgangspunktet planlagt til å ha en større rolle)
 */

public class EngineImpl implements Engine {

    private CallbackGUI callbackGUI;

    public EngineImpl(CallbackGUI callbackGUI){
        this.callbackGUI = callbackGUI;
    }

    /**
     * Metoden refererer til panel-klassene
     */
    @Override
    public void updateGUI() {
        callbackGUI.update();
    }

    /* Get methods */
    public CallbackGUI getCallbackGUI() {
        return callbackGUI;
    }


}

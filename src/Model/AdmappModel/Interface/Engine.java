package Model.AdmappModel.Interface;

public interface Engine {

    /**
     * Mottar referanse fra Controllers for å oppdatere gui
     * Skulle originalt brukes til å oppdatere alle panel-klasser
     * samtidig, men en mengde StreamCorruptedErrors stoppa det
     */

    public void updateGUI();
}

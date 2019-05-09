package View.AdmappView.Observer.Interface;

/**
 * Interface som har metoder som gjelder
 * brukergrensesnittet
 */

public interface Callback {
    /**
     * Oppdaterer komponenter/hva de inneholder i sin respektive klasse
     * Blir oftest kalt fra controller-klassene
     */
    public void update();

    /**
     * Legger til alle komponenter panelet skal ha
     */
    public void componentSetup();
}

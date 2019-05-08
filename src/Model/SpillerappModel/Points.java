package Model.SpillerappModel;

import java.io.Serializable;

public class Points implements Serializable {
    private static final long serialVersionUID = 7298087729051984796L;

    private String name;
    private double points;

    public Points(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Navn: " + name + " Poeng: " + points;
    }
    /* Get methods */

    public String getName() {
        return name;
    }

    public double getPoints() {
        return points;
    }


    public void addPoints(double points) {
        this.points += points;
    }
}


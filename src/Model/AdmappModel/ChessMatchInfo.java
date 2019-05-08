package Model.AdmappModel;

import java.io.Serializable;

public class ChessMatchInfo implements Serializable {


    private static final long serialVersionUID = 8826742197789860668L;
    private String name1;
    private String name2;
    private String time;
    private String day;
    private String month;
    private String year;

    private double points1;
    private double points2;

    public ChessMatchInfo(String name1, String name2, String time, String day, String month, String year){
        this.name1 = name1;
        this.name2 = name2;
        this.time = time;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return name1 + " mot " + name2 + " kl: " + time + " Dato: " + day + "/" + month + "/" + year;
    }

    /* Get and set methods */

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }

    public String getTime() {
        return time;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public double getPoints1() {
        return points1;
    }

    public double getPoints2() {
        return points2;
    }

    public void setPoints1(double points1) {
        this.points1 += points1;
    }

    public void setPoints2(double points2) {
        this.points2 += points2;
    }
}

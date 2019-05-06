package Model;

import java.io.Serializable;

public class ChessMatchDate implements Serializable {

    private static final long serialVersionUID = 4694861542429517006L;

    private String name;
    private String time;
    private String day;
    private String month;
    private String year;

    public ChessMatchDate(String name, String time, String day, String month, String year){
        this.name = name;
        this.time = time;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /* Get methods */

    public String getName() {
        return name;
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
}

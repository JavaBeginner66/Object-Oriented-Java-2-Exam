package Model.AdmappModel;

import java.io.Serializable;

public class ChessMatchInfo implements Serializable {

    private static final long serialVersionUID = 4694861842429517006L;

    private String name1;
    private String name2;
    private String time;
    private String day;
    private String month;
    private String year;

    public ChessMatchInfo(String name1, String name2, String time, String day, String month, String year){
        this.name1 = name1;
        this.name2 = name2;
        this.time = time;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /* Get methods */

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
}

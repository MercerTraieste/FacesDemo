package be.cegeka.rszv;

import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;

public class SelectInputDateBean implements Serializable {

    private Date date;

    public SelectInputDateBean() {
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }
}

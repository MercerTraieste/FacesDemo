package be.cegeka.rszv;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.Date;
import java.util.TimeZone;

@ManagedBean
@ViewScoped
public class SelectInputDateBean {

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

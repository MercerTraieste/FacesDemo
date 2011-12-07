package be.cegeka.rszv;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.Date;
import java.util.TimeZone;

/**
 * Managed bean to display the current date
 *
 * @author Adelina Caramet
 * Date: 7/12/11
 * Time: 15:53
 */
@ManagedBean(name="dateSelect")
@RequestScoped
public class SelectInputDateBean {

    private Date date = new Date();

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

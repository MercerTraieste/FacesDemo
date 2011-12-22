package be.cegeka.rsvz;

import be.cegeka.rsvz.validator.Insz;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

@ManagedBean(name = "richBean")
@SessionScoped
public class RichBean implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(RichBean.class);

    private String firstName;
    @NotEmpty(message = "{must-not-be-empty}")
    private String lastName;
    @Past(message = "{date-must-be-in-the-past}")
    private Date calendar;
    private Boolean married;
    private String streetName;
    private String streetNumber;
    private String text;

    @Insz(message = "{insz-not-valid}")
    private String insz;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Date getCalendar() {
        return calendar;
    }

    public void setCalendar(Date calendar) {
        this.calendar = calendar;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getInsz() {
        return insz;
    }

    public void setInsz(String insz) {
        this.insz = insz;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}

package be.cegeka.rsvz;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ManagedBean(name = "richBean")
@SessionScoped
public class RichBean {

    @NotNull
    @NotEmpty(message = "{must-not-be-empty}")
    private String firstName;
    private String lastName;
    @Past
    private Date calendar;

    @NotNull
    @Email(message = "{email-not-well-formatted}")
    private String email;
    private String text;

    public RichBean() {
        firstName = "Cosmin";
        lastName = "Ene";
        setCalendar(new Date());
        setText("Cosmin's text.");
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

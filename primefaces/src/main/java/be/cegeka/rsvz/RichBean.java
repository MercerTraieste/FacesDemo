package be.cegeka.rsvz;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@ManagedBean(name = "richBean")
@SessionScoped
public class RichBean implements Serializable {

    @NotNull
    @Size(min=4, max=10, message = "{must-not-be-empty}")
    private String firstName;
    private String lastName;
    @Past(message = "{date-must-be-in-the-past}")
    private Date calendar;
    private String text;

    public RichBean() {
        firstName = "John";
        lastName = "Doe";
        setCalendar(new Date());
        setText("Please add some text here ...");
    }

    public void validateFirstName(AjaxBehaviorEvent event){
        System.out.println("In validateFirstName ActionListener.");
        System.out.println("First Name: "+getFirstName());
        System.out.println("LastName: "+getLastName());
        FacesMessage msg = new FacesMessage("Succesful is uploaded.");
        FacesContext.getCurrentInstance().addMessage(event.getComponent().getClientId(), msg);
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
}

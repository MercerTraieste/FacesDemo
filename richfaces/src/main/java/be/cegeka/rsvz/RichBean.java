package be.cegeka.rsvz;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean
@SessionScoped
public class RichBean implements Serializable {

    private static final long serialVersionUID = -2403138958014741653L;

    @NotEmpty
    @Pattern(regexp="(?!^[\\s]*$)", message = "{must-not-be-empty}")
//    @NotNull
//    @Size(min=1, message = "{must-not-be-empty}")
    private String firstName;

    @NotBlank
    private String lastName;

    @Past
    private Date calendar;
    private String editorValue;

    @Email
    private String email;

    public RichBean() {
    }

    private List<String> getListOfRandomStrings(int numberOfStrings) {
        List<String> strings = new ArrayList<String>();
        for (int i = 0; i < numberOfStrings; i++) {
            strings.add("rString " + i);
        }

        return strings;
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

    public String getEditorValue() {
        return editorValue;
    }

    public void setEditorValue(String editorValue) {
        this.editorValue = editorValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

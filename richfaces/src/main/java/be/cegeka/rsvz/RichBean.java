package be.cegeka.rsvz;

import org.hibernate.validator.constraints.NotEmpty;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean
@SessionScoped
public class RichBean implements Serializable {

    private static final long serialVersionUID = -2403138958014741653L;

    @NotEmpty(message = "{must-not-be-empty}")
    private String name;

    @NotNull(message = "{must-not-be-null}")
    private Date calendar;
    private String editorValue;

    public RichBean() {
    }

    private List<String> getListOfRandomStrings(int numberOfStrings) {
        List<String> strings = new ArrayList<String>();
        for (int i = 0; i < numberOfStrings; i++) {
            strings.add("rString " + i);
        }

        return strings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}

package be.cegeka.rsvz;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@ManagedBean
@SessionScoped
public class RichBean implements Serializable {

    private static final long serialVersionUID = -2403138958014741653L;

    private String name;
    private Date calendar;
    private String editorValue;

    public RichBean() {
        name = "John";
        editorValue = "";
        calendar = new Date();
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

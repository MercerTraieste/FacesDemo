package be.cegeka.rsvz;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean
@SessionScoped
public class RichBean implements Serializable {

    private static final long serialVersionUID = -2403138958014741653L;

    private String name;
    private Date calendar;
    private String editorValue;

    public RichBean() {
        setName("John");
        setEditorValue("Please add some text here ...");
        setCalendar(new Date());
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

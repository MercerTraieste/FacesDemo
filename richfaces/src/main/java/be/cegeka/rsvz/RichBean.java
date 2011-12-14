package be.cegeka.rsvz;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.*;

@ManagedBean
@SessionScoped
public class RichBean implements Serializable {

    private static final long serialVersionUID = -2403138958014741653L;

    private static final int BIG_LIST_SIZE = 1000;

    private String name;
    private Date calendar;
    private String editorValue;
    private List<String> stringuri;

    public RichBean() {
        name = "John";
        editorValue = "";
        calendar = new Date();
        stringuri = getListOfRandomStrings();
    }

    private List<String> getListOfRandomStrings() {
        return getListOfRandomStrings(BIG_LIST_SIZE);
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

    public List<String> getStringuri() {
        return stringuri;
    }

    public void setStringuri(List<String> stringuri) {
        this.stringuri = stringuri;
    }
}

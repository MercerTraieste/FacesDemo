package be.cegeka.rsvz;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "scrollBean")
@SessionScoped
public class ScrollBean implements Serializable {

    private static final int DISPLAY_SIZE = 10;
    private static final int CAPACITY = 1000;
    private List<Child> children = new ArrayList<Child>(DISPLAY_SIZE);

    public ScrollBean() {
        loadScrollableData();
    }
    
    public void loadScrollableData() {
        for (int i = 1; i <= CAPACITY; i++) {
            children.add(new Child(i, "child "+i+" fname", "child "+i+" lname", i, "M"));
        }
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public int getSize() {
        return DISPLAY_SIZE;
    }

}
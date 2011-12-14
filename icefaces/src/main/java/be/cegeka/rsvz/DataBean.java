package be.cegeka.rsvz;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "dataBean")
@SessionScoped
public class DataBean {

    private final int SIZE = 10;
    
    private List<Child> children = new ArrayList<Child>();
    
    public DataBean() {
       loadData();
    }

    public void loadData() {
        int count = 1000;
        for (int i = 1; i <= count; i++) {
            children.add(new Child(i, "child "+i+" fname", "child "+i+" lname", i, "M"));
        }
    }
    
    public int getSize() {
        return SIZE;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
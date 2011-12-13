package be.cegeka.rsvz;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "dataBean")
@SessionScoped
public class DataBean {
    
    private int size;
    private List<Child> children = new ArrayList<Child>();
    
    public DataBean() {
        setSize(100);
        for (int i = 1; i < 1000; i++) {
            children.add(new Child(String.valueOf(i), "child "+i+" fname", "child "+i+" lname", String.valueOf(i*10), "M"));
        }
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
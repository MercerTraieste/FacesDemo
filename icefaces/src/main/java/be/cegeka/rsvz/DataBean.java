package be.cegeka.rsvz;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "dataBean")
@SessionScoped
public class DataBean {
    
    private List<Child> children = new ArrayList<Child>();
    
    public DataBean() {
        children.add(new Child("1", "child 1 fname", "child 1 lname", "10", "M"));
        children.add(new Child("2", "child 2 fname", "child 2 lname", "20", "F"));
        children.add(new Child("3", "child 3 fname", "child 3 lname", "30", "F"));
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
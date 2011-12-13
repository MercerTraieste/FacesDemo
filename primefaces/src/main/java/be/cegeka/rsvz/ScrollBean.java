package be.cegeka.rsvz;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "scrollBean")
@SessionScoped
public class ScrollBean implements Serializable {

    private static final int SIZE = 10;
    private int offset = 0;
    private List<Child> children = new ArrayList<Child>(SIZE);

    public ScrollBean() {
        loadNextBatch();
    }
    
    public void loadNextBatch() {
        for (int i = offset + 1; i <= offset + SIZE; i++) {
            children.add(new Child(String.valueOf(i), "child "+i+" fname", "child "+i+" lname", String.valueOf(i), "M"));
        }
        offset += SIZE;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
    
    public int getListSize() {
        return children.size();
    }

    public int getSize() {
        return SIZE;
    }

}
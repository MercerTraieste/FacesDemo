package be.cegeka.rsvz;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "dataBean")
@SessionScoped
public class DataBean implements Serializable {
    
    private final int SIZE = 10;
    private LazyDataModel<Child> children;
    
    public DataBean() {
        initLazyModel();
    }
    
    public void initLazyModel() {
        int count = 1000;
        children = new LazyDataModel<Child>() {

            @Override
            public List<Child> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {

                List<Child> children = new ArrayList<Child>();
                populateLazy(children, pageSize, first);

                return children;
            }
        };
        children.setRowCount(count);
        children.setPageSize(SIZE);
    }

    public LazyDataModel<Child> getChildren() {
        return children;
    }

    public void setChildren(LazyDataModel<Child> children) {
        this.children = children;
    }

    public int getSize() {
        return SIZE;
    }

    private void populateLazy(List<Child> children, int size, int first) {
        for(int offset = first + 1 ; offset <= size ; offset++) {
            children.add(new Child(String.valueOf(offset), "child "+offset+" fname", "child "+offset+" lname", String.valueOf(offset*10), "M"));
        }
    }

}
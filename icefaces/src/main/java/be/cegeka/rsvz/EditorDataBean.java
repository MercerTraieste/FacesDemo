package be.cegeka.rsvz;

import org.icefaces.ace.event.RowEditCancelEvent;
import org.icefaces.ace.event.SelectEvent;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;


@ManagedBean(name = "editorDataBean")
@SessionScoped
public class EditorDataBean {
    private final int SIZE = 10;

    private List<Child> children = new ArrayList<Child>();
    private Child selectedChild;

    public EditorDataBean() {
        loadData();
    }

    public void loadData() {
        for (int i = 1; i <= SIZE; i++) {
            children.add(new Child(i, "child " + i + " fname", "child " + i + " lname", i, "M"));
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

    public Child getSelectedChild() {
        return selectedChild;
    }

    public void setSelectedChild(Child selectedChild) {
        this.selectedChild = selectedChild;
    }

    public void rowSelectionDelete(RowEditCancelEvent event) {
        Child child = (Child) event.getObject();
        System.out.println("child = " + child);
        children.remove(child);
        System.out.println("children size = " + children.size());
    }
}

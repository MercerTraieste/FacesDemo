package be.cegeka.rsvz;

import org.richfaces.component.UIExtendedDataTable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ManagedBean(name = "dataBean")
@SessionScoped
public class DataBean implements Serializable {

    private final int SIZE = 40;

    private List<Child> children = new ArrayList<Child>();
    private Collection<Object> selection = null;
    private List<Child> selectedChildren = null;

    /*
    *  FOR EDITABLE TABLE
    */
    private int currentChildIndex;
    private Child editedChild;

    public DataBean() {
        loadData();
    }

    public void loadData() {
        int count = 100;
        for (int i = 1; i <= count; i++) {
            children.add(new Child(i, "child " + i + " fname", "child " + i + " lname", i, "M"));
        }
    }

    public void storeChild() {
        children.set(currentChildIndex, editedChild);
        System.out.println("Stored child: [" + currentChildIndex + "]" + editedChild.toString());
    }

    public void removeChild() {
        children.remove(children.get(currentChildIndex));
        System.out.println("Deleted child: [" + currentChildIndex + "]" + children.get(currentChildIndex).toString());
    }

    public void showSelectionDetails(AjaxBehaviorEvent event) {
        UIExtendedDataTable table = (UIExtendedDataTable) event.getComponent();
        selectedChildren = new ArrayList<Child>();
        selection = table.getSelection();
        Object storedRowKey = table.getRowKey();
        System.out.println("Selected children:");
        for (Object rowKey : selection) {
            table.setRowKey(rowKey);
            selectedChildren.add((Child) table.getRowData());
            System.out.println("Child: " + table.getRowData());
        }
        table.setRowKey(storedRowKey);
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

    public Collection<Object> getSelection() {
        return selection;
    }

    public void setSelection(Collection<Object> selection) {
        this.selection = selection;
    }

    public List<Child> getSelectedChildren() {
        return selectedChildren;
    }

    public void setSelectedChildren(List<Child> selectedChildren) {
        this.selectedChildren = selectedChildren;
    }

    public int getCurrentChildIndex() {
        return currentChildIndex;
    }

    public void setCurrentChildIndex(int currentChildIndex) {
        this.currentChildIndex = currentChildIndex;
    }

    public Child getEditedChild() {
        return editedChild;
    }

    public void setEditedChild(Child editedChild) {
        this.editedChild = editedChild;
    }
}
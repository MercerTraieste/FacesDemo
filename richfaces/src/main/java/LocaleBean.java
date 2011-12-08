import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@ManagedBean
@SessionScoped
public class LocaleBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String localeCode;

    private List<SelectItem> languages;

    public LocaleBean() {
        languages = new ArrayList<SelectItem>();
        languages.add(new SelectItem("en_US", "English"));
        languages.add(new SelectItem("it_IT", "Italian"));
        localeCode = "it_IT";
    }

    public List<SelectItem> getLanguages() {
        return languages;
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    public void localeChanged() {
        changeLocale();
    }

    private void changeLocale() {
        if ("en_US".equals(localeCode)) {
            FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
        } else if ("it_IT".equals(localeCode)) {
            FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ITALIAN);

        } else {
            throw new RuntimeException("Locale" + localeCode + " not supported");
        }
    }
}
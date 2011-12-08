import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@ManagedBean
@SessionScoped
public class LocaleBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String localeCode;

    private Map<String, Object> languages;

    public LocaleBean() {
        languages = new LinkedHashMap<String, Object>();
        languages.put("English", Locale.ENGLISH); //label, value
        languages.put("Italian", Locale.ITALIAN);
        localeCode = "en";
    }

    public Map<String, Object> getLanguages() {
        return languages;
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    public void countryLocaleCodeChanged() {
        String newLocaleValue = localeCode;
        changeLanguage(newLocaleValue);
    }

    private void changeLanguage(String newLocaleValue) {
        for (Map.Entry<String, Object> entry : languages.entrySet()) {
            if (entry.getValue().toString().equals(newLocaleValue)) {
                FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());
            }
        }
    }

}
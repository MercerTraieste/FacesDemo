package be.cegeka.rsvz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Locale;

@ManagedBean
@SessionScoped
public class LocaleBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = LoggerFactory.getLogger(LocaleBean.class);
    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.toString();
    }

    public void setLanguage(String language) {
        locale = extractLocale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }

    private Locale extractLocale(String localeCode) {
        String language = localeCode.substring(0, 2);
        String country;
        if (localeCode.length() >= 2) {
            country = localeCode.substring(3, 5);
        } else {
            country = "";
        }
        LOG.info("Setting locale to language={} country={}", language, country);
        return new Locale(language, country);
    }

}

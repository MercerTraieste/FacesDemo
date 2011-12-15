package be.cegeka.rsvz;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Ordering;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.*;

@ManagedBean
@SessionScoped
public class LocaleBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = LoggerFactory.getLogger(LocaleBean.class);

    private Locale locale;
    private Set<Locale> locales;

    public LocaleBean() {
        this.locales = extractLocales();
        LOG.info("Server has these locales: {}", locales);
        this.locale = extractBrowserLocale();
        LOG.info("Locale set to [{}]", locale);
    }

    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.toString();
    }

    public List<SelectItem> getLanguages() {
        List<SelectItem> languages = new ArrayList<SelectItem>();

        for (Locale locale : locales) {
            languages.add(localeToSelectItem(locale));
        }

        return languages;
    }

    public void setLanguage(String language) {
        locale = extractLocale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }

    private Locale extractBrowserLocale() {
        Locale browserLocale = ((HttpServletRequest) (FacesContext.getCurrentInstance().
                getExternalContext().getRequest())).getLocale();
        LOG.info("Browser locale is [{}]", browserLocale);
        Locale strippedLocale = new Locale(browserLocale.getLanguage());
        if (locales.contains(strippedLocale)) {
            return strippedLocale;
        } else {
            return getDefaultLocale();
        }
    }

    private Locale getDefaultLocale() {
        return FacesContext.getCurrentInstance().getApplication().getDefaultLocale();
    }

    public static Locale extractLocale(String localeCode) {
        String language = localeCode.substring(0, 2);
        String country;
        if (localeCode.length() > 2) {
            country = localeCode.substring(3, 5);
        } else {
            country = "";
        }
        return new Locale(language, country);
    }

    private Set<Locale> extractLocales() {
        Set<Locale> locales = new HashSet<Locale>();
        locales.add(getDefaultLocale());
        Iterator<Locale> i = FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
        while (i.hasNext()) {
            locales.add(i.next());
        }

        Function<Locale, String> localeToString = new Function<Locale, String>() {
            public String apply(Locale from) {
                return from.getDisplayName();
            }
        };

        Ordering<Locale> localeOrdering = Ordering.natural().onResultOf(localeToString);

        return ImmutableSortedSet.orderedBy(
                localeOrdering).addAll(locales).build();
    }

    private SelectItem localeToSelectItem(Locale locale) {
        if (locale != null) {
            return new SelectItem(locale.toString(), locale.getDisplayName());
        }
        return null;
    }

}

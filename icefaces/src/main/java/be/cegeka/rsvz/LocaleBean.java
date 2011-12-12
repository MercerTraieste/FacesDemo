package be.cegeka.rsvz;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@ManagedBean(name = "localeBean")
@SessionScoped
public class LocaleBean implements Serializable {
    private List<SelectItem> availableLocales;
    private Locale currentLocale;
    private String dropdownItem;

    public LocaleBean() {
        setCurrentLocale(FacesContext.getCurrentInstance().getApplication().getDefaultLocale());
        dropdownItem = currentLocale.getLanguage();
    }

    private void createAvailableLocales() {
        availableLocales = new ArrayList<SelectItem>(0);

        availableLocales.add
                (setLocaleItem(FacesContext.getCurrentInstance().getApplication().getDefaultLocale()));

        for (Iterator<Locale> iter =
                     FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
             iter.hasNext(); ) {
            availableLocales.add(setLocaleItem(iter.next()));
        }
    }

    private SelectItem setLocaleItem(Locale locale) {
        if (locale != null) {
            return new SelectItem(locale.getLanguage(),
                    locale.getDisplayName());
        }
        return null;
    }

    public List<SelectItem> getAvailableLocales() {
        if (availableLocales == null) {
            createAvailableLocales();
        }

        return availableLocales;
    }

    public void setAvailableLocales(List<SelectItem> availableLocales) {
        this.availableLocales = availableLocales;
    }

    public Locale getCurrentLocale() {
        return currentLocale;
    }

    public void setCurrentLocale(Locale currentLocale) {
        this.currentLocale = currentLocale;
    }

    public String getDropdownItem() {
        return dropdownItem;
    }

    public void setDropdownItem(String dropdownItem) {
        this.dropdownItem = dropdownItem;
    }

    public void applyLocale(Locale locale) {
        setCurrentLocale(locale);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }

    public void localeChanged(ValueChangeEvent event) {
        if (event.getNewValue() != null) {
            applyLocale(new Locale(event.getNewValue().toString()));
        }
    }

    public void localeChanged() {
        applyLocale(new Locale(dropdownItem));
    }
}

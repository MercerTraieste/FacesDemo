package be.cegeka.rsvz.ui;

import be.cegeka.rsvz.LocaleBean;
import be.cegeka.rsvz.faces.i18n.UTF8ResourceBundle;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.ExtendedHtmlUnitDriver;

import java.util.Locale;
import java.util.ResourceBundle;

public class HomePageTest extends BaseTest {
    private static final String[] LOCALES = {"en", "el", "fr", "en-GB", "nl"};

    @Test
    public void localesShouldBeAvailable() {
        for (String locale : LOCALES) {
            ExtendedHtmlUnitDriver localeDriver = new ExtendedHtmlUnitDriver();
            localeDriver.setHeader("Accept-Language", locale);
            localeDriver.get(BaseTest.BASE_URL);
            WebElement element = localeDriver.findElement(By.id("languageLabel"));
            Locale referenceLocale = LocaleBean.extractLocale(locale);
            ResourceBundle res = UTF8ResourceBundle.getBundle("be.cegeka.rsvz.faces.i18n.messages", referenceLocale);
            Assert.assertEquals(res.getString("language"), element.getText());
            localeDriver.quit();
        }
    }

    @Test
    public void localeChangeShouldChangeTheLocale() throws Exception {
        getDriver().get(BaseTest.BASE_URL);
        Assert.assertTrue(new HomePage(getDriver()).changeLanguage());
    }

}

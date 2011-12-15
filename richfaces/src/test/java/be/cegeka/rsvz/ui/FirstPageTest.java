package be.cegeka.rsvz.ui;

import be.cegeka.rsvz.LocaleBean;
import be.cegeka.rsvz.faces.i18n.UTF8ResourceBundle;
import be.cegeka.rsvz.webdriver.GlassFishServer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.ExtendedHtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class FirstPageTest {
    private static final int PORT = 9999;
    private static final String CONTEXT = "facesdemo";
    private static final String BASE_URL = "http://localhost:" + PORT + "/" + CONTEXT;
    private static final String[] LOCALES = {"en", "el", "fr", "nl", "en-GB"};

    private WebDriver driver;

    @Before
    public void startGlassfish() throws Exception {
        GlassFishServer.run();
        driver = new FirefoxDriver(createProfile());
    }

    @Test
    public void allLocalesShouldBeAvailable() {
        for (String locale : LOCALES) {
            ExtendedHtmlUnitDriver localeDriver = new ExtendedHtmlUnitDriver();
            localeDriver.setHeader("Accept-Language", locale);
            localeDriver.get(BASE_URL);
            WebElement element = localeDriver.findElement(By.id("languageLabel"));
            Locale referenceLocale = LocaleBean.extractLocale(locale);
            ResourceBundle res = UTF8ResourceBundle.getBundle("be.cegeka.rsvz.faces.i18n.messages", referenceLocale);
            Assert.assertEquals(res.getString("language"), element.getText());
            localeDriver.quit();
        }
    }

    @Test
    public void changeLanguageFromEnglishToDutch() throws Exception {
        driver.get(BASE_URL);
        WebElement element = driver.findElement(By.id("languageLabel"));
        Assert.assertEquals("Language", element.getText());

        WebElement select = driver.findElement(By.id("selectLanguage"));
        Actions builder = new Actions(driver);
        builder.moveToElement(select).click().perform();

        WebElement selectItem = driver.findElement(By.id("selectLanguageItem4"));
        Actions builderSelectItem = new Actions(driver);
        builderSelectItem.moveToElement(selectItem).click().perform();

//        waitForAsyncContent("languageLabel");
        Thread.sleep(10000);

        WebElement selectLanguageInput = driver.findElement(By.id("selectLanguageInput"));
        System.out.println("Select language value: " + selectLanguageInput.getAttribute("value"));

        element = driver.findElement(By.id("languageLabel"));
        Assert.assertEquals("Taal", element.getText());

        /*List<WebElement> children = select.findElements(By.tagName("input"));
        System.out.println("Children:");
        for(WebElement elem : children){
            System.out.println(elem);
        }*/

    }

    private String getLocalPath() throws IOException {
        String canonicalPath = new File(".").getCanonicalPath();
        if (canonicalPath.indexOf("richfaces") > 0) {
            return canonicalPath;
        } else {
            return canonicalPath + "/richfaces";
        }
    }

    private FirefoxProfile createProfile() throws Exception {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.http.phishy-userpass-length", 255);
        profile.addExtension(new File(getLocalPath() + "/src/test/resources/firebug-1.8.4.xpi"));
        profile.setPreference("extensions.firebug.currentVersion", "1.8.4");
        return profile;
    }

    public void waitForAsyncContent(String id) {
        WebElement e = driver.findElement(By.id(id));
        int timeSpent = 0;
        for (int i = 0; i < 20; i++) {
            if (e.isDisplayed()) {
                break;
            }
            try {
                Thread.sleep(1000);
                i += 1;
            } catch (InterruptedException ex) {
            }
        }
        System.out.println("Time spent: " + timeSpent);
    }

}

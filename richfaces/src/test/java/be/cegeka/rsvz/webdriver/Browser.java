package be.cegeka.rsvz.webdriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Browser {

    private static String URL;

    private static Browser instance;

    private WebDriver driver;

    private Browser() {
        initDriver();
    }

    private void initDriver() {
        driver = new HtmlUnitDriver();
    }

    public void open() {
        driver.get(URL);
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    private void quit() {
        driver.quit();
    }

    public void executeScript(String javascript) {
        ((JavascriptExecutor) driver).executeScript(javascript);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static synchronized Browser getBrowser() {
        if (instance == null) {
            instance = new Browser();
            Runtime.getRuntime().addShutdownHook(new Thread() {

                @Override
                public void run() {
                    instance.quit();
                }
            });
        }
        return instance;
    }

    public static void use(String url) {
        URL = url;
    }
}

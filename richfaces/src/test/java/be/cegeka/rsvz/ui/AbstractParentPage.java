package be.cegeka.rsvz.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public abstract class AbstractParentPage {
    protected WebDriver driver;
    public int DRIVER_WAIT_SECONDS = 30;

    public AbstractParentPage(WebDriver driver) {
        ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT_SECONDS);
        PageFactory.initElements(finder, this);
        this.driver = driver;
    }

}
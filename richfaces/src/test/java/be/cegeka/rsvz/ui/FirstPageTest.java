package be.cegeka.rsvz.ui;

import be.cegeka.rsvz.webdriver.Browser;
import be.cegeka.rsvz.webdriver.EmbeddedSeleniumTestCase;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstPageTest extends EmbeddedSeleniumTestCase {

    @Test
    @Ignore
    public void nameLabelShouldBeName() {
        WebDriver driver = Browser.getBrowser().getDriver();
        driver.get("http://localhost:9999/web/");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        WebElement element = driver.findElement(By.id("nameLabel"));
        Assert.assertEquals("Name", element.getText());
    }
}

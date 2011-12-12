package be.cegeka.rsvz.ui;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class FirstPageTest {

    @Test
    public void nameLabelShouldBeName() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:9000/richfaces/");
        WebElement element = driver.findElement(By.id("nameLabel"));
        Assert.assertEquals("Name", element.getText());
    }
}

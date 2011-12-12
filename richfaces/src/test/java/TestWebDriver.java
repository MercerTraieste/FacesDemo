import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestWebDriver {

    public static void main(String args[]) {
        // Create an instance of WebDriver backed by Firefox
        WebDriver driver = new FirefoxDriver();

        // Now go to the Google home page
        driver.get("http://www.google.com");

        // Find the search box, and (ummm...) search for something
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("selenium");
        searchBox.submit();

        // And now display the title of the page
        System.out.println("Title: " + driver.getTitle());

    }
}

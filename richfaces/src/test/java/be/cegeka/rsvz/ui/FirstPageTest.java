package be.cegeka.rsvz.ui;

import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishProperties;
import org.glassfish.embeddable.GlassFishRuntime;
import org.glassfish.embeddable.archive.ScatteredArchive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.File;
import java.io.IOException;

public class FirstPageTest {
    private static final int PORT = 9999;
    private static final String CONTEXT = "facesdemo";
    private static final String BASE_URL = "http://localhost:" + PORT + "/" + CONTEXT;
    private GlassFish glassfish;
    private WebDriver driver;

    @Before
    public void startServer() throws Exception {
        driver = new HtmlUnitDriver();

        GlassFishProperties gfProps = new GlassFishProperties();
        gfProps.setPort("http-listener", PORT);
        glassfish = GlassFishRuntime.bootstrap().newGlassFish(gfProps);
        glassfish.start();
        File webRoot = new File(getLocalPath() + "/src/main/webapp");
        File classes = new File(getLocalPath() + "/target/classes");
        ScatteredArchive archive = new ScatteredArchive(CONTEXT, ScatteredArchive.Type.WAR, webRoot);
        archive.addClassPath(classes);
        glassfish.getDeployer().deploy(archive.toURI());
    }

    @Test
    public void languageLabelShouldBeLanguage() {
        driver.get(BASE_URL + "/");
        WebElement element = driver.findElement(By.id("languageLabel"));
        Assert.assertEquals("Language", element.getText());
    }

    @After
    public void closeServer() throws Exception {
        glassfish.stop();
        glassfish.dispose();
    }

    private String getLocalPath() throws IOException {
        String canonicalPath = new File(".").getCanonicalPath();
        if (canonicalPath.indexOf("richfaces") > 0) {
            return canonicalPath;
        } else {
            return canonicalPath + "/richfaces";
        }
    }

}

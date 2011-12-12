package be.cegeka.rsvz.webdriver;

import org.apache.catalina.LifecycleException;
import org.junit.After;
import org.junit.Before;

import java.net.MalformedURLException;

public class EmbeddedSeleniumTestCase {

    @Before
    public void startServer() throws MalformedURLException, LifecycleException {
        TomcatServer server = new TomcatServer("web");
        server.run(9999);
        Browser.use(getUrl(JettyServer.getUrl()));
        Browser.getBrowser().open();
    }

    @After
    public void cleanUpSession() {
        Browser.getBrowser().deleteAllCookies();
    }

    protected String getUrl(String baseUrl) {
        return baseUrl;
    }

}

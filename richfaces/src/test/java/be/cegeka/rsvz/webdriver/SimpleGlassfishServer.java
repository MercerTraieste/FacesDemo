package be.cegeka.rsvz.webdriver;

import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishProperties;
import org.glassfish.embeddable.GlassFishRuntime;
import org.glassfish.embeddable.archive.ScatteredArchive;

import java.io.File;

public class SimpleGlassfishServer {

    public static void main(String[] args) throws Exception {
        GlassFishProperties gfProps = new GlassFishProperties();
        gfProps.setPort("http-listener", 9999);
        GlassFish glassfish = GlassFishRuntime.bootstrap().newGlassFish(gfProps);
        glassfish.start();

        File webRoot = new File("d:/w/FacesDemo/richfaces/src/main/webapp");
        ScatteredArchive archive = new ScatteredArchive("web", ScatteredArchive.Type.WAR, webRoot);
        archive.addClassPath(new File("d:/w/FacesDemo/richfaces/target/classes"));
        archive.addClassPath(new File("d:\\w\\FacesDemo\\richfaces\\src\\main\\", "webapp"));
        glassfish.getDeployer().deploy(archive.toURI());
    }
}

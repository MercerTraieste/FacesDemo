package be.cegeka.rsvz.webdriver;

import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishProperties;
import org.glassfish.embeddable.GlassFishRuntime;
import org.glassfish.embeddable.archive.ScatteredArchive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class GlassFishServer {

    private static final Logger LOG = LoggerFactory.getLogger(GlassFishServer.class);

    private static final int PORT = 9999;
    private static final String CONTEXT = "facesdemo";

    private static GlassFish glassFish;
    private static GlassFishServer instance;

    public static synchronized void run() {
        if (instance == null) {
            instance = new GlassFishServer();
            instance.start();

            Runtime.getRuntime().addShutdownHook(new Thread() {

                @Override
                public void run() {
                    instance.stop();
                    LOG.info("Glassfish server instance stopped with thread.");
                }
            });
        }
    }


    private void stop() {
        try {
            glassFish.stop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void start() {

        try {
            init();
            glassFish.start();

            File webRoot = new File(getLocalPath() + "/src/main/webapp");
            File classes = new File(getLocalPath() + "/target/classes");
            ScatteredArchive archive = new ScatteredArchive(CONTEXT, ScatteredArchive.Type.WAR, webRoot);
            archive.addClassPath(classes);
            glassFish.getDeployer().deploy(archive.toURI());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void init() throws Exception {
        GlassFishProperties gfProps = new GlassFishProperties();
        gfProps.setPort("http-listener", PORT);
        glassFish = GlassFishRuntime.bootstrap().newGlassFish(gfProps);
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

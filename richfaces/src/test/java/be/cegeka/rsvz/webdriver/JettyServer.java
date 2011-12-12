package be.cegeka.rsvz.webdriver;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.ResourceCollection;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyServer {

    private static final int PORT = 7070;
    private static final String URL = "http://localhost:" + PORT;

    private static JettyServer instance;

    private Server server;

    private void start() {
        init();
        try {
            server.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void init() {
        server = new Server(PORT);
        server.setHandler(createWebAppContext());
        server.setStopAtShutdown(true);
    }

    private WebAppContext createWebAppContext() {
        WebAppContext context = new WebAppContext();

        //context.setDescriptor("d:\\Work\\Projects\\FacesDemo\\richfaces\\src\\main\\webapp\\WEB-INF\\web.xml");
//        context.setWar("d:/richfaces-1.0-SNAPSHOT.war");
        context.setContextPath("/");
        context.setBaseResource(
                new ResourceCollection(
                        new String[] {"./richfaces/src/main/webapp", "./richfaces/target"}));
        context.setContextPath("/");
        context.setParentLoaderPriority(true);

        return context;
    }

    private void stop() {
        try {
            server.stop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized void run() {
        if (instance == null) {
            instance = new JettyServer();
            instance.start();

            Runtime.getRuntime().addShutdownHook(new Thread() {

                @Override
                public void run() {
                    instance.stop();
                }
            });
        }
    }

    public static String getUrl() {
        return URL;
    }

}

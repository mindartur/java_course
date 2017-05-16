package servlets;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.Servlet;

/**
 * Created by artur on 16/05/17.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Servlet frontend = new FrontendServlet();

        Server server = new Server(8090);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(context);
        context.addServlet(new ServletHolder(frontend), "/*");

        server.start();
        server.join();
    }
}

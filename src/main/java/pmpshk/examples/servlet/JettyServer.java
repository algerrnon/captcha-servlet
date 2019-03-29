package pmpshk.examples.servlet;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class JettyServer {
	public static void main(String[] args) throws Exception {
		Server server = new Server();
		ServerConnector connector = new ServerConnector(server);
		connector.setPort(8090);
		server.setConnectors(new Connector[]{connector});

		ServletContextHandler contextHandler = new ServletContextHandler();
		contextHandler.setContextPath("/");
		contextHandler.addServlet(SimpleCaptchaServlet.class, "/");

		HandlerCollection handlers = new HandlerCollection();
		handlers.setHandlers(new Handler[]{contextHandler, new DefaultHandler()});
		server.setHandler(handlers);

		server.start();
		server.join();
	}
}

package ch.javaprofi_academy.web.tomcat;

import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

public class TomcatStarter {

	private static final Logger LOG = Logger.getLogger(TomcatStarter.class.getName());

	private TomcatStarter() {
	}

	public static void startTomcat() {
		final Tomcat tomcat = new Tomcat();
		final Connector connector = new Connector();
		tomcat.setConnector(connector);
		connector.setPort(7777); // 8080
		tomcat.addWebapp("", Paths.get(".").toAbsolutePath().toString());
		try {
			tomcat.start();
			LOG.log(Level.INFO, "tomcat started successfully!");
		} catch (Exception e) {
			LOG.log(Level.INFO, "tomcat not started", e);
		}
	}
}

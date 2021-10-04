package ch.asmiq;

import java.util.logging.Logger;

import ch.asmiq.tomcat.TomcatStarter;


public class AsmiqAcademyApp {

	private static final Logger LOG = Logger.getLogger(AsmiqAcademyApp.class.getName());

	public static void main(final String[] args) throws InterruptedException {
		
		TomcatStarter.startTomcat();
	}
}
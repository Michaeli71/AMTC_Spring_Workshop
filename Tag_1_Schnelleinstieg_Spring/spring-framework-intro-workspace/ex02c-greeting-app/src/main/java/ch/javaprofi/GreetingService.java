package ch.javaprofi;

import java.util.logging.Logger;

public class GreetingService {

	private static final Logger LOG = Logger.getLogger(GreetingService.class.getName());

	public void sayHello() {
		LOG.info("Welcome to Spring Workshop :-)");
	}
}

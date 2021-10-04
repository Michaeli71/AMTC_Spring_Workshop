package ch.javaprofi;

import java.util.logging.Logger;

public class GreetingService {

	private static final Logger LOG = Logger.getLogger(GreetingService.class.getName());

	private String msgText;

	public GreetingService(String msgText) {
		this.msgText = msgText;
	}

	public void sayHello() {
		LOG.info(msgText);
	}

}

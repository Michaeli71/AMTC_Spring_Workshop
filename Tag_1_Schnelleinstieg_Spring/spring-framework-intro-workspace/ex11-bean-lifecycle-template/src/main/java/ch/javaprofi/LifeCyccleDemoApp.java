package ch.javaprofi;

import java.util.logging.Logger;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch.javaprofi.beans.FirstTryBean;

public class LifeCyccleDemoApp {

	private static final Logger LOG = Logger.getLogger(LifeCyccleDemoApp.class.getName());

	public static void main(String[] args) {
		LOG.info("It works");
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-config.xml");

		var firstBean = applicationContext.getBean(FirstTryBean.class);
		
		applicationContext.close();
	}
}

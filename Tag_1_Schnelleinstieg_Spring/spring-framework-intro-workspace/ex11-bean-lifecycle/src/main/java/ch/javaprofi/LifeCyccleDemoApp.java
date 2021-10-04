package ch.javaprofi;

import java.util.logging.Logger;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch.javaprofi.beans.FirstTryBean;
import ch.javaprofi.beans.LifeCycleDemoBean;

public class LifeCyccleDemoApp {

	private static final Logger LOG = Logger.getLogger(LifeCyccleDemoApp.class.getName());

	public static void main(String[] args) throws InterruptedException {
		LOG.info("It works");
		
		//ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-config.xml");
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-config-with-context-scan.xml");

		var firstBean = applicationContext.getBean(FirstTryBean.class);

		var secondBean = applicationContext.getBean(LifeCycleDemoBean.class);
		
		
		Thread.sleep(1_000);
		applicationContext.close();
	}
}

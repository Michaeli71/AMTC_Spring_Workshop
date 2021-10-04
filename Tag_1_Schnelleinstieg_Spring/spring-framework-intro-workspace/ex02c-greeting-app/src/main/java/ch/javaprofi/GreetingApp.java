package ch.javaprofi;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("greeting-app.xml");
		
		GreetingService greetingService = applicationContext.getBean(GreetingService.class);
		greetingService.sayHello();
		
		applicationContext.close();
	}

}

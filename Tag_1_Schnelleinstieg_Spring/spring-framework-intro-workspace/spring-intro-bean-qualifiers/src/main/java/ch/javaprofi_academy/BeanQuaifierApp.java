package ch.javaprofi_academy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch.javaprofi_academy.service.SomeService;

@ComponentScan("ch.javaprofi_academy")
public class BeanQuaifierApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-def.xml");

		var someService = context.getBean(SomeService.class);
		someService.printInfo();

		context.close();
	}
}
package ch.javaprofi_academy;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DependencyConflictResolutionApp {

	public static void main(String[] args) {

		var ctx = new GenericXmlApplicationContext("bean-def.xml");

		SimpleCarByType simpleCar = ctx.getBean(SimpleCarByType.class);
		System.out.println(simpleCar);
		
		/*
		SimpleCarByName simpleCar2 = ctx.getBean(SimpleCarByName.class);
		System.out.println(simpleCar2);
		*/
		
		var wheel = ctx.getBean(Wheel.class);
		System.out.println(wheel);
		
		ctx.close();
	}
}

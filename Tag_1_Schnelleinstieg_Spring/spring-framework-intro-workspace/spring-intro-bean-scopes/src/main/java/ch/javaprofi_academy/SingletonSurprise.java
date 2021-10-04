package ch.javaprofi_academy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SingletonSurprise {
	public static void main(String[] args) {
		var ctx = new ClassPathXmlApplicationContext("shapes.xml");

		Shape shape1 = ctx.getBean("scopeTest", Shape.class);
		Shape shape2 = ctx.getBean("scopeTestDuplicate", Shape.class);

		System.out.println(shape1 == shape2);
		System.out.println(shape1 + "::" + shape2);
		
		Shape shape3 = ctx.getBean("scopeTest", Shape.class);
		Shape shape4 = ctx.getBean("scopeTestDuplicate", Shape.class);
		System.out.println(shape1 == shape3);
		System.out.println(shape2 == shape4);
		System.out.println(shape3 + "::" + shape4);
	}
}

package ch.javaprofi_academy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan("ch.javaprofi_academy")
public class BeanScopesApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-def.xml");

		var shape1 = context.getBean(Shape.class);
		System.out.println(shape1);

		shape1.setColor("blue");
		System.out.println(shape1);

		var shape2 = context.getBean(Shape.class);
		System.out.println(shape2);

		context.close();
	}
}
package ch.javaprofi_academy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("ch.javaprofi_academy")
public class SingletonPerContextExample {

	public static void main(String[] args) {
		var container = new AnnotationConfigApplicationContext(SingletonPerContextExample.class);
		var container2 = new AnnotationConfigApplicationContext(SingletonPerContextExample.class);

		var shape1 = container.getBean(Shape.class);
		System.out.println(shape1);

		shape1.setColor("blue");
		System.out.println(shape1);

		var shape2 = container2.getBean(Shape.class);
		System.out.println(shape2);
	}
}
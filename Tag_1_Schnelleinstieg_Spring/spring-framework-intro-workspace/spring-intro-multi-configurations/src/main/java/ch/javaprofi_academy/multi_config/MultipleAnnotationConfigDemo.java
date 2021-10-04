package ch.javaprofi_academy.multi_config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch.javaprofi_academy.simple_xml_config.Customer;

public class MultipleAnnotationConfigDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportBeansConfig.class);
		
		ExampleBean exampleBean = context.getBean(ExampleBean.class);
		Customer customerBean = context.getBean("newMikeCustomer", Customer.class);
		
		System.out.println(exampleBean);
		System.out.println(customerBean);
		
		context.close();
	}
}
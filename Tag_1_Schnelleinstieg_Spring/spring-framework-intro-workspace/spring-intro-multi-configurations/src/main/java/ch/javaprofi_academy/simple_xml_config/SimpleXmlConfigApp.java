package ch.javaprofi_academy.simple_xml_config;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleXmlConfigApp
{
	public static void main(String[] args) {

		var ctx = new GenericXmlApplicationContext("bean-def.xml");

		var cust1 = ctx.getBean("customer1");
		var cust2 = ctx.getBean("customer2");

		System.out.println(cust1);
		System.out.println(cust2);

		ctx.close();
	}
}

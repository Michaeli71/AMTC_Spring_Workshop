package ch.javaprofi_academy.autowiringmodes;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiringDemo {

	public static void main(String[] args) {
		// ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		ApplicationContext context = new ClassPathXmlApplicationContext("bean-resolution.xml");

		System.out.println("-------------------- by name ------------------------");
		ClientBean bean1 = context.getBean("clientBeanByName", ClientBean.class);
		System.out.println(bean1);
		// System.out.println(bean1.printService.msg);
		
		System.out.println("-------------------- by type ------------------------");
		ClientBean bean2 = context.getBean("clientBeanByType", ClientBean.class);
		System.out.println(bean2);
		System.out.println(bean2.printService.msg);
		
		System.out.println("-------------------- by constructor ------------------------");
		ClientBean bean3 = context.getBean("clientBeanByConstructor", ClientBean.class);
		System.out.println(bean3);
		System.out.println(bean3.printService.msg);
		
		// context.close();
	}

	private static class ClientBean {
		private MsgServiceBean service1;
		private MsgServiceBean otherService;
		private PrintServiceBean printService;

		public ClientBean() {
			System.out.println("ClientBean() called");
		}

		public ClientBean(MsgServiceBean service, PrintServiceBean printService) {
			System.out.println("ClientBean(...) called");
			this.service1 = service;
			this.printService = printService;
		}
		
		public MsgServiceBean getService1() {
			return service1;
		}

		public void setService1(MsgServiceBean service1) {
			System.out.println("setService1(...) called");
			this.service1 = service1;
		}

		public MsgServiceBean getOtherService() {
			return otherService;
		}

		public void setOtherService(MsgServiceBean otherService) {
			System.out.println("setOtherService(...) called");
			this.otherService = otherService;
		}

		public PrintServiceBean getPrintService() {
			return printService;
		}

		public void setPrintService(PrintServiceBean printService) {
			System.out.println("setPrintService(...) called");
			this.printService = printService;
		}

		@Override
		public String toString() {
			return "ClientBean [service1=" + service1 + ", otherService=" + otherService + ", printService="
					+ printService + "]";
		}

	}

	private static class MsgServiceBean {
		private String msg;

		public MsgServiceBean(String msg) {
			this.msg = msg;
		}

		public String getMsg() {
			return msg;
		}
	}

	private static class PrintServiceBean {
		private String msg;

		public PrintServiceBean(String msg) {
			this.msg = msg;
		}

		public void printMsg() {
			System.out.println(msg);
		}
	}

	
	
	// unused in ClassPath XML Mode
	public static class Config {

		@Bean(autowire = Autowire.BY_NAME)
		@Lazy
		public ClientBean clientBeanByName() {
			return new ClientBean();
		}

		@Bean(autowire = Autowire.BY_TYPE)
		@Lazy
		public ClientBean clientBeanByType() {
			return new ClientBean();
		}

		@Bean
		@Lazy
		public ClientBean clientBeanByConstructor() {
			return new ClientBean();
		}

		@Bean(name = "service1")
		public MsgServiceBean serviceBean1() {
			return new MsgServiceBean("Service bean 1");
		}

		/*
		@Bean
		public MsgServiceBean serviceBean2() {
			return new MsgServiceBean("Service bean 2");
		}
		*/

		@Bean
		public PrintServiceBean printer() {
			return new PrintServiceBean("printer");
		}
	}
}
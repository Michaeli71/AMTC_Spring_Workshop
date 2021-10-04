package ch.asmiq;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import ch.asmiq.model.Course;
import ch.asmiq.model.Customer;
import ch.asmiq.model.Order;
import ch.asmiq.service.AsmiqAcademyService;

@ComponentScan("ch.asmiq")
public class AsmiqAcademyApp {

	private static final Logger LOG = Logger.getLogger(AsmiqAcademyApp.class.getName());

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				AsmiqAcademyApp.class);
		AsmiqAcademyService asmiqAcademyService = applicationContext.getBean(AsmiqAcademyService.class);

		var optJavaCourse = findFirstCourseByTopic(asmiqAcademyService, "Java");

		var karthi = new Customer("karthi", "Bollu-Str. 6, 8051 Zürich");
		var michael = new Customer("michael", "In der Ey 50, 8047 Zürich");

		optJavaCourse.ifPresentOrElse(course -> {
			placeOrder(asmiqAcademyService, course, karthi);
		}, AsmiqAcademyApp::handleCourseNotPresent);

		optJavaCourse.ifPresentOrElse(course -> {
			placeOrder(asmiqAcademyService, course, michael);
		}, AsmiqAcademyApp::handleCourseNotPresent);

		applicationContext.close();

	}

	private static void placeOrder(AsmiqAcademyService academyService, Course course, Customer customer) {

		Order order = createOrder(course, customer);
		academyService.placeOrder(order);
	}

	private static Order createOrder(Course course, Customer customer) {
		Order order = new Order();
		order.setCustomer(customer);
		order.setCourse(course);
		return order;
	}

	private static Optional<Course> findFirstCourseByTopic(AsmiqAcademyService academyService, String topic) {
		return academyService.getCourses().stream().filter(course -> course.getName().contains(topic)).findAny();
	}

	private static void handleCourseNotPresent() {
		LOG.info("No order has been placed!!");
	}

}
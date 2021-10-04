package ch.asmiq;

import java.util.Optional;
import java.util.logging.Logger;

import ch.asmiq.model.Course;
import ch.asmiq.model.Customer;
import ch.asmiq.model.Order;
import ch.asmiq.service.AsmiqAcademyService;
import ch.asmiq.service.CourseService;
import ch.asmiq.service.SmsService;

public class AsmiqAcademyApp {

	private static final Logger LOG = Logger.getLogger(AsmiqAcademyApp.class.getName());

	public static void main(String[] args) {
		CourseService courseService = new CourseService();
		SmsService smsService = new SmsService();

		AsmiqAcademyService asmiqAcademyService = new AsmiqAcademyService(courseService, smsService);
		
		var optJavaCourse = findFirstCourseByTopic(asmiqAcademyService, "Java");

		var karthi = new Customer("karthi", "Bollu-Str. 6, 8051 Zürich");
		var michael = new Customer("michael", "In der Ey 50, 8047 Zürich");

		optJavaCourse.ifPresentOrElse(course -> {
			placeOrder(asmiqAcademyService, course, karthi);
		}, AsmiqAcademyApp::handleCourseNotPresent);
		
		optJavaCourse.ifPresentOrElse(course -> {
			placeOrder(asmiqAcademyService, course, michael);
		}, AsmiqAcademyApp::handleCourseNotPresent);		
	}

	private static void placeOrder(AsmiqAcademyService academyService, 
			                       Course course, Customer customer) {

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
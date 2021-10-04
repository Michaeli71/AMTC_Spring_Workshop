package ch.asmiq.service;

import java.util.List;

import org.springframework.stereotype.Component;

import ch.asmiq.interfaces.CourseService;
import ch.asmiq.interfaces.NotificationService;
import ch.asmiq.model.Course;
import ch.asmiq.model.Order;

@Component
public class AsmiqAcademyService {

	private CourseService courseService;
	private NotificationService notificationService;

	public AsmiqAcademyService(CourseService courseService, NotificationService notificationService) {
		this.courseService = courseService;
		this.notificationService = notificationService;
	}

	public List<Course> getCourses() {
		return courseService.getCourses();
	}
	
	public void placeOrder(Order order){
		notificationService.sendNotification(order);
	}

}

package ch.asmiq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ch.asmiq.interfaces.AcademyService;
import ch.asmiq.interfaces.CourseService;
import ch.asmiq.interfaces.NotificationService;
import ch.asmiq.model.Course;
import ch.asmiq.model.Order;

@Service
public class AsmiqAcademyServiceUsingQualifier implements AcademyService {

	private CourseService courseService;
	private NotificationService notificationService;

	public AsmiqAcademyServiceUsingQualifier(@Qualifier("onlineCourseService") CourseService courseService,
			@Qualifier("smsService") NotificationService notificationService) {
		
//	public AsmiqAcademyServiceUsingQualifier(@Qualifier("liveCourseService") CourseService courseService,
//			@Qualifier("emailService") NotificationService notificationService) {
				
		this.courseService = courseService;
		this.notificationService = notificationService;
	}

	public List<Course> getCourses() {
		return courseService.getCourses();
	}

	public void placeOrder(Order order) {
		notificationService.sendNotification(order);
	}
}
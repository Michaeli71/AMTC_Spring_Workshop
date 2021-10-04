package ch.asmiq.service;

import java.util.List;

import org.springframework.stereotype.Component;

import ch.asmiq.model.Course;
import ch.asmiq.model.Order;

@Component
public class AsmiqAcademyService {

	private CourseService courseService;
	private SmsService smsService;

	public AsmiqAcademyService(CourseService courseService, SmsService smsService) {
		this.courseService = courseService;
		this.smsService = smsService;
	}

	public List<Course> getCourses() {
		return courseService.getCourses();
	}
	
	public void placeOrder(Order order){
		smsService.sendNotification(order);
	}

}

package ch.asmiq.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ch.asmiq.interfaces.CourseService;
import ch.asmiq.model.Course;
import ch.asmiq.model.Courses;

@Primary
@Service
public class OnlineCourseService implements CourseService {

	@Override
	public List<Course> getCourses() {
		// Original JAXB kommt nicht mit immutable lists zurecht
		return  List.of(new Course("Java (Online)", 2, new BigDecimal(50)), new Course("Design Patterns (Online)", 3, new BigDecimal(60)),
				new Course("Testing (Online)", 1, new BigDecimal(40)));
	}

}

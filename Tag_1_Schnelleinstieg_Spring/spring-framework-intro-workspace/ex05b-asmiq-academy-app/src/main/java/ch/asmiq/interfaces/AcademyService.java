package ch.asmiq.interfaces;

import java.util.List;

import ch.asmiq.model.Course;
import ch.asmiq.model.Order;

public interface AcademyService {
	public List<Course> getCourses();

	public void placeOrder(Order order);
}

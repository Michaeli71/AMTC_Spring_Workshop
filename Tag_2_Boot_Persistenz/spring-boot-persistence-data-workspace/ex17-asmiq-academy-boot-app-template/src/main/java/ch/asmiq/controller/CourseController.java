package ch.asmiq.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.asmiq.model.Course;
import ch.asmiq.service.AsmiqAcademyService;


@RestController
public class CourseController {
	
	private AsmiqAcademyService asmiqAcademyService;

	public CourseController(AsmiqAcademyService asmiqAcademyService) {
		this.asmiqAcademyService = asmiqAcademyService;
	}

	@GetMapping("/courses")
	public List<Course> courses(){
		return asmiqAcademyService.getCourses();
	}

}
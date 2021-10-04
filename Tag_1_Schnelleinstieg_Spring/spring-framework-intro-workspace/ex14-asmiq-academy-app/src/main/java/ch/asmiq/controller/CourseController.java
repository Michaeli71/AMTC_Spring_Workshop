package ch.asmiq.controller;

import java.util.List;

import org.springframework.http.MediaType;
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

	//@GetMapping("/courses")
	@GetMapping(value="/courses", produces= { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Course> courses(){
		return asmiqAcademyService.getCourses();
		// für XML
		//return new ArrayList<>(asmiqAcademyService.getCourses());
	}

}
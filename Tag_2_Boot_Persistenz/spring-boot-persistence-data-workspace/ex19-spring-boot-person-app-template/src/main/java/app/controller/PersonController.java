package app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.model.Person;

@RestController
@RequestMapping("/persons")
public class PersonController {

	private List<Person> persons = new ArrayList<>();
	
	// TODO
}

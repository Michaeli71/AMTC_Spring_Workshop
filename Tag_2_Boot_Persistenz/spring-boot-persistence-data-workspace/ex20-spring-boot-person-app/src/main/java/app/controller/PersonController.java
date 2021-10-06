package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.controller.service.PersonService;
import app.model.Person;

@RestController
@RequestMapping("/persons")
public class PersonController {

	private final PersonService personService;
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@GetMapping
	public List<Person> getAll() {

		return personService.getAll();
	}

	@PostMapping("/fromAttributes")
	public Person createFromAttributes(@RequestParam String name, @RequestParam String nationality,
			@RequestParam String age) {

		final Person newPerson = new Person(name, nationality, Integer.valueOf(age));

		return personService.createNewPerson(newPerson);
	}

	@PostMapping
	public Person createFromPerson(@RequestBody final Person newPerson) {
		return personService.createNewPerson(newPerson);
	}

	@GetMapping("/filter-by-nationality")
	public List<Person> getByNationality(String nationality) {
		return personService.getByNationality(nationality);
	}

	@GetMapping("/filter-older-than")
	public List<Person> getOlderThan(Integer age) {
		return personService.getOlderThan(age);
	}
}

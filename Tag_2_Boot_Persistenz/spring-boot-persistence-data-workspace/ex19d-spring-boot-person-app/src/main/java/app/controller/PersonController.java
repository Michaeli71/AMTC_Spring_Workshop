package app.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.model.Person;

@RestController
@RequestMapping("/persons")
public class PersonController {

	private List<Person> persons = new ArrayList<>();
	
	@GetMapping
	public List<Person> getAll() {

		return Collections.unmodifiableList(persons);
	}

	@PostMapping("/fromAttributes")
	public Person createFromAttributes(@RequestParam String name, 
                                        @RequestParam String nationality, 
                                        @RequestParam String age) {
		
		final Person newPerson = 
                          new Person(name, nationality, Integer.valueOf(age));
		
		persons.add(newPerson);
		
		return newPerson;
	}

	@PostMapping
	public Person createFromPerson(@RequestBody final Person newPerson) {
		persons.add(newPerson);		
		return newPerson;
	}

	@GetMapping("/filter-by-nationality")
	public List<Person> getByNationality(String nationality) {		
		return persons.stream().
	                   filter(person -> person.getNationality().
                                           equals(nationality)).
	                   collect(Collectors.toList());
	}
	
	@GetMapping("/filter-older-than")
	public List<Person> getOlderThan(Integer age) {
		return persons.stream().
	                     filter(person -> person.getAge() > age).
	                     collect(Collectors.toList());
	}
}

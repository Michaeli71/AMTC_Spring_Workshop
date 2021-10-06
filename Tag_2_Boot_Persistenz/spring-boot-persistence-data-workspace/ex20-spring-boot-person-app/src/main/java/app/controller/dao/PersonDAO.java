package app.controller.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import app.model.Person;

@Repository
public class PersonDAO {

	private List<Person> persons = new ArrayList<>();

	public List<Person> findAll() {

		return Collections.unmodifiableList(persons);
	}

	public void save(Person person) {

		persons.add(person);
	}

	public List<Person> findByNationality(String nationality) {
		Predicate<Person> byNationality = person -> person.getNationality().equals(nationality);

		return filter(byNationality);
	}

	public List<Person> findOlderThan(Integer age) {
		Predicate<Person> olderThan = person -> person.getAge() > age;

		return filter(olderThan);
	}

	// only suitable for list as data store 
	private List<Person> filter(Predicate<? super Person> filterCriterion) {
		return persons.stream().filter(filterCriterion).collect(Collectors.toList());
	}

}

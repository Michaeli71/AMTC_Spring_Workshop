package ch.asmiq.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import ch.asmiq.model.Person;

@Repository
public class PersonDAO {


	public List<Person> getAllPersons() {
		return List.of(new Person(1L, "Michael", "Inden", 50), 
				       new Person(2L, "Tim", "Bötzmeyer", 50));
	}
}

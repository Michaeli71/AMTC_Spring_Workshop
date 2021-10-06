package app.controller.service;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.controller.dao.PersonDAO;
import app.model.Person;

@Service
public class PersonService {

	final PersonDAO personDao;
	
	@Autowired
	public PersonService(PersonDAO personDao) {
		this.personDao = personDao;
	}

	public List<Person> getAll() {
		return personDao.findAll();
	}

	public Person createNewPerson(Person person) {
		personDao.save(person);
		return person;
	}

	public List<Person> getByNationality(String nationality) {
		return personDao.findByNationality(nationality);
	}

	public List<Person> getOlderThan(Integer age) {
		return personDao.findOlderThan(age);
	}
}

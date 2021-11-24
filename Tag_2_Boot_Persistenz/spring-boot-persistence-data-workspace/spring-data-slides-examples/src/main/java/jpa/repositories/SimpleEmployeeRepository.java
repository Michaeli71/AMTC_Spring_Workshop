package jpa.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jpa.entities.SimpleEmployee;

public interface SimpleEmployeeRepository extends CrudRepository<SimpleEmployee, Long> {

  SimpleEmployee findByFirstName(String firstName);

  List<SimpleEmployee> findByLastName(String lastName);
}

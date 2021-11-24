package mongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import mongo.documents.SimpleEmployee;

public interface SimpleEmployeeRepository extends MongoRepository<SimpleEmployee, String> {
	SimpleEmployee findByFirstName(String firstName);

	List<SimpleEmployee> findByLastName(String lastName);
}

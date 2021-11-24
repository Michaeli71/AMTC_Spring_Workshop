package mongo.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import mongo.documents.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String>
{
	Employee findByFirstName(String firstName);
    List<Employee> findByLastName(String lastName);

    List<Employee> findByAgeGreaterThan(int age);
    List<Employee> findByAgeBetween(int lower, int upper);
    int countByAgeBetween(int lower, int upper);

    List<Employee> findTop3ByAgeLessThan(int maxAge);
    List<Employee> findByAgeLessThanOrderByFirstNameAsc(int maxAge);

    List<Employee> getByFirstNameLike(String firstName);

    List<Employee> findByFirstNameOrLastName(String firstName, String lastName);

    List<Employee> findByLastNameInAndAgeBetween(Collection<String> names, int lower, int upper);
}
package jpa.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import jpa.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>
{
	Employee findByFirstName(String firstName);
    List<Employee> findByLastName(String lastName);

    List<Employee> findByAgeGreaterThan(int age);
    List<Employee> findByAgeBetween(int lower, int upper);
    int countByAgeBetween(int lower, int upper);

    List<Employee> findTop3ByAgeLessThan(int maxAge);
    List<Employee> findByAgeLessThanOrderByFirstNameAsc(int maxAge);

    @Query("SELECT emp FROM Employee emp WHERE emp.firstName LIKE %?1%")
    List<Employee> getFirstNameLike(String firstName);    
    // List<Employee> getByFirstNameLike(String firstName);
    
    List<Employee> findByFirstNameOrLastName(String firstName, String lastName);

    List<Employee> findByLastNameInAndAgeBetween(Collection<String> names, int lower, int upper);
}
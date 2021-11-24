package jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee 
{
	@Id
	@GeneratedValue
	private Long id;
	private String firstName, lastName, description;
	private int age;

	private Employee() {
	}

	public Employee(String firstName, String lastName, String description, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", description="
				+ description + ", age=" + age + "]";
	}

	
	
}

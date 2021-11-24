package mongo.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee 
{
	@Id
	private String id;
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

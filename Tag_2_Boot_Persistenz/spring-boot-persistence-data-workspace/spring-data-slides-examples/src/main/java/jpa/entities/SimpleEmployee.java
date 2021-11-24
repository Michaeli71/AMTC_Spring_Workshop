package jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SimpleEmployee 
{
	@Id
	@GeneratedValue
	private Long id;
	private String firstName, lastName, description;

	private SimpleEmployee() {
	}

	public SimpleEmployee(String firstName, String lastName, String description) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
	}

	@Override
	public String toString() {
		return "SimpleEmployee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", description="
				+ description + "]";
	}
}

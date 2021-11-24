package mongo.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SimpleEmployee {

	@Id
	private String id;
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

package exercises;

import java.time.LocalDate;

public class Customer {

	private String salutation;

	private String firstName;
	private String lastName;

	private Integer age;
	
	private LocalDate birthday;
	
	private LocalDate nextHoliday;

	public Customer() {
	}

	public Customer(String salutation, String firstName, String lastName, 
			       Integer age, LocalDate birthday, LocalDate nextHoliday) {
		this.salutation = salutation;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.birthday = birthday;
		this.nextHoliday = nextHoliday;
	}
}
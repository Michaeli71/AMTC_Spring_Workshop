package solutions;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class Customer {

	@Pattern(regexp = "^Herr|Frau$")
	private String salutation;

	@NotBlank(message = "first name must not be empty")
	@Size(min = 2, max = 100)
	private String firstName;
	
	@NotBlank(message = "last name must not be empty")
	private String lastName;

	@PositiveOrZero
	// @Min(0)
	// @Max(150)
	private Integer age;
	
	@Past
	private LocalDate birthday;
	
	@FutureOrPresent
	private LocalDate nextHoliday;
	
	@Email
	private String contactEmail;

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
package exercises;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

public class CustomerValidationExample {

	public static void main(String[] args) 
	{
		CustomerValidationExample app = new CustomerValidationExample();
		List<@Valid Customer> customerList = app.populateCustomerList();

		try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory())
		{
			// TODO		
		}
	}


	private List<@Valid Customer> populateCustomerList() {
		
		List<@Valid Customer> customerList = new ArrayList<>();

		customerList.add(new Customer("Mrs", "Michael", "Inden", 20, LocalDate.of(1971, 2, 7), LocalDate.of(2021, 6, 10)));
		customerList
				.add(new Customer("Dr", "James", "Gosling", 30, LocalDate.of(1961, 7, 16), LocalDate.of(2021, 11, 11)));
		customerList
				.add(new Customer("Herr", "Don", "Smith", -10, LocalDate.of(1971, 3, 27), LocalDate.of(2020, 10, 10)));

		return customerList;
	}
}

package step1;

import exercise.Customer;

public interface ICustomerRepository {
	Customer findById(final long customerId);
}

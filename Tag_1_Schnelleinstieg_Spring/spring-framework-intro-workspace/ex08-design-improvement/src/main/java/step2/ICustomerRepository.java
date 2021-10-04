package step2;

import exercise.Customer;

public interface ICustomerRepository {
	Customer findById(final long customerId);
}

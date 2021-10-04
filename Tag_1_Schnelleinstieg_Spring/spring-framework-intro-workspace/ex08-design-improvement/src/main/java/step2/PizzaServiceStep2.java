package step2;

import java.util.HashMap;
import java.util.Map;

import exercise.Customer;
import exercise.Discount;
import exercise.Pizza;
import exercise.Receipt;

public class PizzaServiceStep2 {
	private final ICustomerRepository customerRepository;
	private final Map<Long, Receipt> customerToReceipt = new HashMap<>();

	public PizzaServiceStep2(final ICustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public void orderPizza(final long customerId, final Pizza pizza, final IDiscountStrategy discountStrategy) {
		final Customer customer = customerRepository.findById(customerId);
		customerToReceipt.putIfAbsent(customerId, new Receipt(customer));
		final Receipt receipt = customerToReceipt.get(customerId);

		final double price = discountStrategy.apply(pizza);
		receipt.addEntry(pizza, price);
	}
}
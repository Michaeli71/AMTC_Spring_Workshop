package step1;

import java.util.HashMap;
import java.util.Map;

import exercise.Customer;
import exercise.Discount;
import exercise.Pizza;
import exercise.Receipt;

public class PizzaServiceStep1 {
	private final IDiscountStrategy discountStrategy;
	private final ICustomerRepository customerRepository;
	private final Map<Long, Receipt> customerToReceipt = new HashMap<>();

	public PizzaServiceStep1() {
		// Direkte Abhängigkeiten, aber schon mal gekapselt
		discountStrategy = new XL_HalfPrice_Discount();
		customerRepository = new CustomerDAO();
	}

	public void orderPizza(final long customerId, final Pizza pizza) {
		final Customer customer = customerRepository.findById(customerId);
		customerToReceipt.putIfAbsent(customerId, new Receipt(customer));
		final Receipt receipt = customerToReceipt.get(customerId);

		final double price = discountStrategy.apply(pizza);
		receipt.addEntry(pizza, price);
	}
}
package exercise;

import java.util.HashMap;
import java.util.Map;

public class PizzaService {
	private final Discount discount;
	private final CustomerDAO customerDAO;
	private final Map<Long, Receipt> customerToReceipt = new HashMap<>();

	public PizzaService() {
		// Direkte Abhängigkeiten 
		discount = new Discount();
		customerDAO = new CustomerDAO();
	}

	public void orderPizza(final long customerId, final Pizza pizza) {
		final Customer customer = customerDAO.findById(customerId);
		customerToReceipt.putIfAbsent(customerId, new Receipt(customer));
		final Receipt receipt = customerToReceipt.get(customerId);

		final double price = discount.apply(pizza);
		receipt.addEntry(pizza, price);
	}
}
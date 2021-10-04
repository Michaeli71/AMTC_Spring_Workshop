package ch.asmiq.service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import ch.asmiq.interfaces.PaymentService;
import ch.asmiq.model.Order;

@Service
@PropertySource("classpath:sixPaymentService.properties")
public class SixPaymentService implements PaymentService {

	private static final Logger LOG = Logger.getLogger(SixPaymentService.class.getName());
	
	@Value("${discount.percent}")
	private BigDecimal discountPercent;
	
	@Override
	public void doPay(Order order) {
		BigDecimal coursePrice = order.getCourse().getPrice();
		BigDecimal discountPrice = coursePrice.multiply(discountPercent);
		BigDecimal totalPrice = coursePrice.subtract(discountPrice);
		
		LOG.info("Total amount paid: " + NumberFormat.getInstance().format(totalPrice));
	}
}
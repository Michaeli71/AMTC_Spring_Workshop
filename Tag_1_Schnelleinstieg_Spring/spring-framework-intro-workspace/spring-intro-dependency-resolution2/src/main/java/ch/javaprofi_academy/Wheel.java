package ch.javaprofi_academy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("car.properties")
public class Wheel {

	@Value("${wheel.radius:1.234}")
	private double radius = -1.0d;

	@Override
	public String toString() {
		return "Wheel [radius=" + radius + "]";
	}
	
	
}


package ch.javaprofi_academy.model;

import org.springframework.stereotype.Component;

// @Component
public class Manager implements Person {

	@Override
	public String getDescription() {

		return "Manager";
	}
}
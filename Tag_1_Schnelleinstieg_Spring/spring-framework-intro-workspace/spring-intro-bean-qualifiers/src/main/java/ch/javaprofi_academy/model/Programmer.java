package ch.javaprofi_academy.model;

import org.springframework.stereotype.Component;

// not used if Config
// @Component
public class Programmer implements Person {

	@Override
	public String getDescription() {

		return "Programmer";
	}
}
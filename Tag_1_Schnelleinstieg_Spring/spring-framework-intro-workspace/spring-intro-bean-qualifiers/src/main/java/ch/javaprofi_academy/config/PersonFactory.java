package ch.javaprofi_academy.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch.javaprofi_academy.model.Manager;
import ch.javaprofi_academy.model.Person;
import ch.javaprofi_academy.model.Programmer;

// comment to enable Quailifer / Component
@Configuration
public class PersonFactory {

	@Bean
	@Qualifier("programmer")
	public Person createProgrammer() {

		return new Programmer();
	}

	@Bean
	@Qualifier("manager")
	public Person createManager() {

		return new Manager();
	}
}
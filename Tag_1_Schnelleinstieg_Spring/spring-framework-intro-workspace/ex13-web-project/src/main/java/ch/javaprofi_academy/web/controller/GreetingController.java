package ch.javaprofi_academy.web.controller;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	private static final Logger LOG = Logger.getLogger(GreetingController.class.getName());

	@GetMapping("/hello")
	public String greet() {
		// '&#x1f605' => Browser
		// toSurrogates(0x0001F309) => Konsole
		String message = "Welcome Spring Workshop Participants '&#x1f605' " + toSurrogates(0x0001F309);
		LOG.info(message);
		return message;
	}

	@GetMapping("/hello/{name}")
	public String greetWith(@PathVariable String name) {
		return "Welcome " + name;
	}

	private static String toSurrogates(final int orig) {
		return new String(new char[] { Character.highSurrogate(orig), Character.lowSurrogate(orig) });
	}
	
	
	// Surrogate-Demo
	public static void main(String[] args) {
		 var message = "Welcome Spring Workshop Participants '&#x1f605' " + toSurrogates(0x1f605);
		 System.out.println(message);		 
	}
}

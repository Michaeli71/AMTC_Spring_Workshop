package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import app.controller.PersonController;

@SpringBootApplication
public class PersonApp implements CommandLineRunner {
	
	@Autowired
	private PersonController controller;

	public static void main(String[] args) {
		SpringApplication.run(PersonApp.class, args);
	}

	public void run(String... args) throws Exception {
		controller.createFromAttributes("Micha", "german", "47");
		controller.createFromAttributes("Tim", "german", "47");
		controller.createFromAttributes("Carlo", "swiss", "44");
		controller.createFromAttributes("Beat", "swiss", "25");
		controller.createFromAttributes("Jean Bernard", "french", "55");
		controller.createFromAttributes("Jean", "swiss", "15");
		controller.createFromAttributes("Armin", "german", "22");
		controller.createFromAttributes("Tom", "american", "7");
		controller.createFromAttributes("James", "british", "707");
	}
}

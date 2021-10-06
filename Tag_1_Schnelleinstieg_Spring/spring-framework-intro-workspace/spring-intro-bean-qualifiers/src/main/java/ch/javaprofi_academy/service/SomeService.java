package ch.javaprofi_academy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ch.javaprofi_academy.model.Person;

@Service
public class SomeService {
	@Autowired
	@Qualifier("programmer")
	private Person p1;

	@Autowired
	@Qualifier("manager")
	private Person p2;

	public void printInfo() {
		System.out.println(p1.getDescription());
		System.out.println(p2.getDescription());
	}
}
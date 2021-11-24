package jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);
}
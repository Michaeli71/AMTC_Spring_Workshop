package jpa;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jpa.entities.Customer;
import jpa.entities.Employee;
import jpa.entities.SimpleEmployee;
import jpa.repositories.CustomerRepository;
import jpa.repositories.EmployeeRepository;
import jpa.repositories.SimpleEmployeeRepository;

@SpringBootApplication
public class JpaDataAccessApplication implements CommandLineRunner {
	
	@Autowired
	private CustomerRepository repository;

	@Autowired
	private SimpleEmployeeRepository simpleEmployeeRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	
	private static final Logger log = LoggerFactory.getLogger(JpaDataAccessApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaDataAccessApplication.class);
	}

	@Override
	public void run(String... args) throws Exception {
		performCustomerActions();
		
		performSimpleEmployeeActions();
		
		performEmployeeActions();
	}

	protected void performEmployeeActions() {
        Employee emp1 = new Employee("Michael", "Inden", "Team Lead", 47);
        Employee emp2 = new Employee("Karthi", "Bollu Ganesh", "Lead Engineer", 33);
        Employee emp3 = new Employee("Marcello", "Fluri", "Senior SW Engineer", 52);
        Employee emp4 = new Employee("Marco", "Sonderegger", "SW Engineer", 30);
        Employee emp5 = new Employee("Numa", "Trezzini", "SW Engineer", 30);
        Employee emp6 = new Employee("Martin", "Dorta", "Senior SW Engineer", 50);
        	
        employeeRepository.save(emp1);
        employeeRepository.save(emp2);
        employeeRepository.save(emp3);
        employeeRepository.save(emp4);
        employeeRepository.save(emp5);		
        employeeRepository.save(emp6);
		
        System.out.println("Employees 40-50: " + employeeRepository.findByAgeBetween(40, 50));
        System.out.println("#Employees 40-50: " + employeeRepository.countByAgeBetween(40, 50));
        
        System.out.println("Employees > 40: " + employeeRepository.findByAgeGreaterThan(40));
        System.out.println("Employees < 50 Top 3: " + employeeRepository.findTop3ByAgeLessThan(50));
        System.out.println("Employess: " + employeeRepository.findByAgeLessThanOrderByFirstNameAsc(35));
        		
        System.out.println("Employees: " + employeeRepository.getFirstNameLike("Ma"));
        		
        System.out.println("Employees: " + employeeRepository.findByFirstNameOrLastName("Michael", 
                                                                                "Fluri"));
	}

	protected void performSimpleEmployeeActions() {
		SimpleEmployee emp1 = new SimpleEmployee("Michael", "Inden", "Team Lead");
		SimpleEmployee emp2 = new SimpleEmployee("Karthi", "Bollu Ganesh", "Lead Engineer");
		SimpleEmployee emp3 = new SimpleEmployee("Marcello", "Fluri", "Senior SW Engineer");
			
		System.out.println("Employees: " + simpleEmployeeRepository.count());
		simpleEmployeeRepository.save(emp1);
		simpleEmployeeRepository.save(emp2);
		simpleEmployeeRepository.save(emp3);		
		System.out.println("Employees: " + simpleEmployeeRepository.count());
		System.out.println("Employees: " + simpleEmployeeRepository.findAll());
			
		// Find + Delete
		SimpleEmployee marcello = simpleEmployeeRepository.findByFirstName("Marcello");
		simpleEmployeeRepository.delete(marcello);		
		System.out.println("Employees: " + simpleEmployeeRepository.count());
		System.out.println("Employees: " + simpleEmployeeRepository.findAll());
	}

	protected void performCustomerActions() {
		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Susanne", "Bauer"));
		repository.save(new Customer("Kim", "Basinger"));
		repository.save(new Customer("Donna", "Summer"));
		repository.save(new Customer("Michelle", "Hunziker"));

		// fetch all customers
		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (Customer customer : repository.findAll()) {
			log.info(customer.toString());
		}
		log.info("");

		// fetch an individual customer by ID
		Optional<Customer> customer = repository.findById(1L);
		if (customer.isPresent()) {
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.get().toString());
			log.info("");
		}

		// fetch customers by last name
		log.info("Customer found with findByLastName('Bauer'):");
		log.info("--------------------------------------------");
		for (Customer bauer : repository.findByLastName("Bauer")) {
			log.info(bauer.toString());
		}
		log.info("");
	}
}

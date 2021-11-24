package mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mongo.documents.Customer;
import mongo.documents.Employee;
import mongo.documents.SimpleEmployee;
import mongo.repositories.CustomerRepository;
import mongo.repositories.EmployeeRepository;
import mongo.repositories.SimpleEmployeeRepository;

@SpringBootApplication
public class MongoDbSampleApplication implements CommandLineRunner {
	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private SimpleEmployeeRepository simpleEmployeeRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	

	public static void main(String[] args) {
		SpringApplication.run(MongoDbSampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("--------------------------------");
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("--------------------------------");
		System.out.println("Customers found with findByLastName('Smith'):");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}

		// ------------------------------------

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

		System.out.println("Employees: " + employeeRepository.getByFirstNameLike("Ma"));

		System.out.println("Employees: " + employeeRepository.findByFirstNameOrLastName("Michael", "Fluri"));
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
}
package app;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ExampleSpringBootApp {

	public static void main(String[] args) {
		SpringApplication.run(ExampleSpringBootApp.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			inspectSpring(ctx);
		};
	}

	private void inspectSpring(ApplicationContext ctx) {
		System.out.println("Beans provided by Spring Boot:");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		Arrays.stream(beanNames).forEach(System.out::println);
	}
}

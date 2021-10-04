package ch.javaprofi_academy.multi_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CustomerConfig {
    @Bean
    public Customer newMikeCustomer() {
       return new Customer("Michael", "Zürich");
    }
    
    @Bean
    public Customer newTimCustomer() {
       return new Customer("Tim", "Kiel");
    }
}
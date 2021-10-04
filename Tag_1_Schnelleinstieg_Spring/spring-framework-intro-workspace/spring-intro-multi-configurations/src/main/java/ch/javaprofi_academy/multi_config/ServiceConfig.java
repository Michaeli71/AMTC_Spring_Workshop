package ch.javaprofi_academy.multi_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig 
{
	@Bean
	public ServiceBean serviceBean() 
	{
		return new ServiceBean();
	}
}
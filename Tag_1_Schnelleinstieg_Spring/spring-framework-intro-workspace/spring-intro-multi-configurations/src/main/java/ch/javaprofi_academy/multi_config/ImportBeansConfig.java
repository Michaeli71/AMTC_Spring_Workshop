package ch.javaprofi_academy.multi_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CustomerConfig.class, ServiceConfig.class})
public class ImportBeansConfig {
  @Bean
  public ExampleBean exampleBean() {
    return new ExampleBean();
  }
}
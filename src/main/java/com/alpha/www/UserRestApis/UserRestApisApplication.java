package com.alpha.www.UserRestApis;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot REST API Documentation", 
				description = "Spring Boot REST API Documentation", 
				version = "v1.0", 
				contact = @Contact(
						name = "Nishit", 
						email = "nishitmasih32@gmail.com", 
						url = "https://www.linkedin.com/in/nishit-masih/"
						), 
				license = @License(
						name = "Apache 2.0", 
						url = "https://www.linkedin.com/in/nishit-masih/"
						)
				), 
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot User Management Documentation", 
				url = "https://www.linkedin.com/in/nishit-masih/"
				)
		)
public class UserRestApisApplication {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(UserRestApisApplication.class, args);
	}

}

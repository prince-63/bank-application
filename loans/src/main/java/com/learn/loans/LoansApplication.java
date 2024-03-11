package com.learn.loans;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@OpenAPIDefinition(
		info = @Info(
				title = "Loans microservice REST API Documentation",
				description = "YourBank Loans microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Prince Kumar",
						email = "princekumar.priku@gmail.com",
						url = "https://princekumar.xyz"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://princekumar.xyz"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "YourBank Loans microservice REST API Documentation",
				url = "https://princekumar.xyz/swagger-ui.html"
		)
)
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "AuditAwareImpl")
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}

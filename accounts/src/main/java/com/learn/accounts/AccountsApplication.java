package com.learn.accounts;

import com.learn.accounts.dto.AccountContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(value = {AccountContactInfoDto.class})
@EnableJpaAuditing(auditorAwareRef = "AuditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservice REST API Documentation",
				description = "YourBank Accounts microservice REST API Documentation",
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
				description =  "YourBank Accounts microservice REST API Documentation",
				url = "https://princekumar.xyz/swagger-ui.html"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}

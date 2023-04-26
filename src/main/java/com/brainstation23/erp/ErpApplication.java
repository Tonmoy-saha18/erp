package com.brainstation23.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableJpaRepositories
public class ErpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpApplication.class, args);
	}
	
	@Bean
    	public OpenAPI openAPI() {
        	return new OpenAPI()
                	.addServersItem(new Server().url("/"));
    	}

}

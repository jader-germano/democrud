package com.poc.democrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DemoCrudApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoCrudApplication.class, args);
	}

}

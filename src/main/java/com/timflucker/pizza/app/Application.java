package com.timflucker.pizza.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the application. Initializes H2 database, and configures all
 * Spring components.
 * 
 * @author Tim Flucker
 *
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

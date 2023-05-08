package com.timflucker.pizza.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timflucker.pizza.app.model.Customer;
import com.timflucker.pizza.app.repository.CustomerRepository;

@RestController
public class PizzaController {

	@Autowired
	private CustomerRepository customerRepo;
	
	@GetMapping("/test")
	String test() {
		return "Success!";
	}
	
	
	@GetMapping("/customers")
	List<Customer> getAllCustomers(){
		return customerRepo.findAll();
	}
	
	
}

package com.timflucker.pizza.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.timflucker.pizza.app.model.Customer;
import com.timflucker.pizza.app.model.Pizza;
import com.timflucker.pizza.app.service.CustomerService;
import com.timflucker.pizza.app.service.PizzaService;

@RestController
@RequestMapping(value = "/pizza-app")
public class PizzaController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/test")
	String test() {
		return "Success!";
	}

	
	@GetMapping("/customers")
	List<Customer> getAllCustomers(){
		return customerService.retrieveAllCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	Customer getCustomer(@PathVariable(name = "customerId",required = true) long customerId) {
		return customerService.retrieveCustomer(customerId);
	}
	
	@GetMapping("/viewMenu")
	@ResponseBody
	List<Pizza> viewMenu(){
		return pizzaService.retrieveAllPizzas();
	}
		
}

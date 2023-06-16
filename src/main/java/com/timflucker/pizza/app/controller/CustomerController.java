package com.timflucker.pizza.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.timflucker.pizza.app.dto.CustomerDTO;
import com.timflucker.pizza.app.model.Customer;
import com.timflucker.pizza.app.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/pizza-app")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	
	@GetMapping("/customers")
	List<Customer> getAllCustomers() {
		return customerService.retrieveAllCustomers();
	}

	@GetMapping("/customer/{customerId}")
	Customer getCustomerByID(@PathVariable(name = "customerId", required = true) long customerId) {
		return customerService.retrieveCustomerID(customerId);
	}
	
	@GetMapping("/customer")
	@ResponseBody
	public Customer getCustomerByName(@RequestParam(value = "customerName", required = true) String customerName) {
		return customerService.retrieveCustomerByName(customerName);
	}
	
	
	@PostMapping("/customer/new")
	ResponseEntity<String> addNewCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
		// create new customer using information provided in DTO object
		Customer customer = customerService.addCustomer(customerDTO.getName(), customerDTO.getPhone(),
				customerDTO.getEmail(), customerDTO.getReceivePromotions());
		// return response entity with message including new customer ID
		return new ResponseEntity<String>("User successfully created with ID: " + customer.getCustomerID(),
				HttpStatus.OK);
	}
}

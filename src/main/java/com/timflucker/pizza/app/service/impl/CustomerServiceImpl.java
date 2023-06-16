package com.timflucker.pizza.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

import com.timflucker.pizza.app.exception.DataNotFoundException;
import com.timflucker.pizza.app.exception.InvalidIdException;
import com.timflucker.pizza.app.model.Customer;
import com.timflucker.pizza.app.repository.CustomerRepository;
import com.timflucker.pizza.app.service.CustomerService;

import io.micrometer.common.util.StringUtils;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private Validator validator;

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public List<Customer> retrieveAllCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public Customer retrieveCustomerID(long customerId) {
		if (isValidCustomerId(customerId)) {
			return customerRepo.findById(customerId).orElseThrow(() -> new DataNotFoundException(customerId));
		} else {
			throw new InvalidIdException(customerId);
		}
	}

	@Override
	public Customer retrieveCustomerByName(String customerName) {
		// validate input (not null, length between 1 - 32)
		if (StringUtils.isNotBlank(customerName) && customerName.length() >= 1 && customerName.length() <= 32) {
			// query db to find customer with customer name, else return error message
			return customerRepo.findByName(customerName)
					.orElseThrow(() -> new DataNotFoundException("Provide customer name not found."));
		}
		return null;
	}

	@Override
	public Customer addCustomer(String name, String phoneNumber, String email, boolean receivePromotions) {
		return customerRepo.save(new Customer(name, phoneNumber, email, receivePromotions));
	}

	@Override
	public Customer updateCustomerInformation(long customerId, Customer newCustomerInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomer(long customerId) {
		// TODO Auto-generated method stub

	}

	private boolean isValidCustomerId(long customerId) {
		return (customerId > 0);
	}

}

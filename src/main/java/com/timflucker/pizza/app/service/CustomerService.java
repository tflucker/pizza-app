package com.timflucker.pizza.app.service;

import java.util.List;

import com.timflucker.pizza.app.model.Customer;

/**
 * Defining service layer methods for the Customer object.
 * @author Tim Flucker
 *
 */
public interface CustomerService {

	/**
	 * Retrieves all Customer objects from the database.
	 * @return
	 */
	public List<Customer> retrieveAllCustomers();
	
	public Customer retrieveCustomer(long customerId);
	
	public Customer addCustomer(String name, String phoneNumber, String email, boolean receivePromotions);
	
	public Customer updateCustomerInformation(long customerId, Customer newCustomerInfo);
	
	public void deleteCustomer(long customerId);
}

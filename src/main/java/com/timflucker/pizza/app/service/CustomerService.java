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
	
	/**
	 * Retrieve the customer with the matching ID value.
	 * @param customerId
	 * @return
	 */
	public Customer retrieveCustomerID(long customerId);
	
	/**
	 * Retrieve the customer with the matching name value
	 * @param customerName
	 * @return
	 */
	public Customer retrieveCustomerByName(String customerName);

	public Customer addCustomer(String name, String phoneNumber, String email, boolean receivePromotions);
	
	public Customer updateCustomerInformation(long customerId, Customer newCustomerInfo);
	
	public void deleteCustomer(long customerId);

}

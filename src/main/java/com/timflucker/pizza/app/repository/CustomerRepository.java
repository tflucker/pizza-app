package com.timflucker.pizza.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timflucker.pizza.app.model.Customer;

/**
 * JPA Repository for the Customer table.
 * 
 * @author Tim Flucker
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	
	public Optional<Customer> findByName(String name);
}

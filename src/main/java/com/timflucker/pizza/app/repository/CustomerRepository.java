package com.timflucker.pizza.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timflucker.pizza.app.model.Customer;

/**
 * JPA Repository for the Customer table.
 * 
 * @author Tim Flucker
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

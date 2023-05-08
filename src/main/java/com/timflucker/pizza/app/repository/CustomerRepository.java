package com.timflucker.pizza.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timflucker.pizza.app.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

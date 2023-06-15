package com.timflucker.pizza.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timflucker.pizza.app.model.PizzaOrder;

/**
 * JPA Repository for the Customer table.
 * 
 * @author Tim Flucker
 *
 */
public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, Long>{

}

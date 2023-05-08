package com.timflucker.pizza.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timflucker.pizza.app.model.PizzaOrder;

public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, Long>{

}

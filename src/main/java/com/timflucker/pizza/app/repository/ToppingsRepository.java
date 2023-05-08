package com.timflucker.pizza.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timflucker.pizza.app.model.Toppings;

public interface ToppingsRepository extends JpaRepository<Toppings, Long>{

}

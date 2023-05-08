package com.timflucker.pizza.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timflucker.pizza.app.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long>{

}

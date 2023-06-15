package com.timflucker.pizza.app.service;

import java.util.List;

import com.timflucker.pizza.app.model.Pizza;

public interface PizzaService {

	
	public List<Pizza> retrieveAllPizzas();
	
	public Pizza retrievePizza(long pizzaId);
}

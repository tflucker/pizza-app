package com.timflucker.pizza.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timflucker.pizza.app.model.Pizza;
import com.timflucker.pizza.app.repository.PizzaRepository;
import com.timflucker.pizza.app.service.PizzaService;

@Service
public class PizzaServiceImpl implements PizzaService{

	@Autowired
	private PizzaRepository pizzaRepository;
	
	@Override
	public List<Pizza> retrieveAllPizzas() {
		return pizzaRepository.findAll();
	}

	@Override
	public Pizza retrievePizza(long pizzaId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

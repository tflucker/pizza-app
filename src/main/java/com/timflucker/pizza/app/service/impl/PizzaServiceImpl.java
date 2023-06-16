package com.timflucker.pizza.app.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timflucker.pizza.app.dto.CustomerOrderDTO;
import com.timflucker.pizza.app.exception.PizzaAppException;
import com.timflucker.pizza.app.model.Customer;
import com.timflucker.pizza.app.model.Pizza;
import com.timflucker.pizza.app.model.PizzaOrder;
import com.timflucker.pizza.app.repository.CustomerRepository;
import com.timflucker.pizza.app.repository.PizzaOrderRepository;
import com.timflucker.pizza.app.repository.PizzaRepository;
import com.timflucker.pizza.app.service.PizzaService;
import com.timflucker.pizza.app.util.UUIDGenerator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PizzaServiceImpl implements PizzaService{

	@Autowired
	private PizzaRepository pizzaRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PizzaOrderRepository pizzaOrderRepository;
	
	@Override
	public List<Pizza> retrieveAllPizzas() {
		return pizzaRepository.findAll();
	}

	@Override
	public Pizza retrievePizza(long pizzaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String orderPizza(CustomerOrderDTO customerOrder) {		
		// get customer using customerID
		Customer customer = customerRepository.findById(customerOrder.getCustomerID()).get();
		// generate alphanumeric order id 
		String uuid = new UUID(UUIDGenerator.get64MostSignificantBitsForVersion1(), UUIDGenerator.get64LeastSignificantBitsForVersion1()).toString();
		
		// find pizzas based on provided info
		List<Pizza> pizzas = new ArrayList<>();
		List<Float> pizzaPrices = new ArrayList<>();
		customerOrder.getPizzas().stream().forEach(p -> {
			Pizza pizza = pizzaRepository.findByNameAndPizzaSize(p.getPizzaName(), p.getSize()).get();
			if(pizza != null) {
//				pizzas.add(pizza);
//				pizzaPrices.add(pizza.getCost());
				PizzaOrder pizzaOrder = new PizzaOrder(customer, uuid, pizza, LocalDate.now(), pizza.getCost());
				
				// save order
				pizzaOrderRepository.save(pizzaOrder);
			} else {
				throw new PizzaAppException("An error occured!");
			}
		}); 
		Float totalPrice = pizzaPrices.stream().reduce(0f, (price1, price2) -> price1 + price2);
		
		// create order object from DTO object
//		PizzaOrder pizzaOrder = new PizzaOrder(customer, uuid, pizzas, LocalDate.now(), totalPrice);
		
		// save order
//		pizzaOrderRepository.save(pizzaOrder);
		// return id of saved order
		
		return uuid;
	}

	
	
}

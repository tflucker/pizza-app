package com.timflucker.pizza.app.dto;

import java.util.List;

import lombok.Data;

@Data
public class CustomerOrderDTO {

	private Long customerID;
	
	private List<PizzaOrderDTO> pizzas;

	public CustomerOrderDTO(Long customerID, List<PizzaOrderDTO> pizzas) {
		super();
		this.customerID = customerID;
		this.pizzas = pizzas;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	public List<PizzaOrderDTO> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<PizzaOrderDTO> pizzas) {
		this.pizzas = pizzas;
	}
	
	
}

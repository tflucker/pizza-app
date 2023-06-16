package com.timflucker.pizza.app.dto;

import lombok.Data;

@Data
public class PizzaOrderDTO {

	private String size;
	private String pizzaName;

	public PizzaOrderDTO(String size, String pizzaName) {
		super();
		this.size = size;
		this.pizzaName = pizzaName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

}

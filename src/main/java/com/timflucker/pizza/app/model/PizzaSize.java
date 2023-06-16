package com.timflucker.pizza.app.model;

public enum PizzaSize {

	SMALL("Small"), MEDIUM("Medium"), LARGE("Large");
	
	private String size;

	private PizzaSize(String size) {
		this.size = size;
	}

	public String getSize() {
		return size;
	}
	
	
}

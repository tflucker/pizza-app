package com.timflucker.pizza.app.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model object representing a customer's order. Contains references to the
 * CUSTOMER and a list of PIZZA they have ordered.
 * 
 * @author Tim Flucker
 *
 */
@Entity
@Data
@NoArgsConstructor
public class PizzaOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PIZZA_ORDER_ID")
	@JsonIgnore
	private Long pizzaOrderID;

	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID", nullable = false)
	private Customer customer;

	@Column(name = "ORDER_ID")
	private String orderID;
	
	@ManyToOne
	@JoinColumn(name = "PIZZA_ID", nullable = false)
	private Pizza pizza;
	
	@NotNull
	private LocalDate orderDate;

	@NotNull
	private Float totalCost;

	public PizzaOrder(Customer customer, String orderID, Pizza pizza, @NotNull LocalDate orderDate,
			@NotNull Float totalCost) {
		super();
		this.customer = customer;
		this.orderID = orderID;
		this.pizza = pizza;
		this.orderDate = orderDate;
		this.totalCost = totalCost;
	}

	
	
}

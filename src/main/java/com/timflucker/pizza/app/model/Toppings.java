package com.timflucker.pizza.app.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model object representing the toppings on a PIZZA.  
 * @author Tim Flucker
 *
 */
@Entity
@Data
@NoArgsConstructor
public class Toppings implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TOPPINGS_ID")
	@JsonIgnore
	private Long toppingsID;

	@NotBlank
	@Length(min = 1, max = 32)
	private String name;

	@NotBlank
	@Length(min = 1, max = 32)
	private String description;

//	@ManyToOne
//	@JoinColumn(name = "pizza_id", nullable = false)
	@JsonBackReference
	@ManyToMany(mappedBy = "pizzaToppings")
//	@JoinTable(name = "PIZZA_TOPPINGS")
	private List<Pizza> pizzas;
}

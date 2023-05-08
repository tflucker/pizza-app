package com.timflucker.pizza.app.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder(toBuilder = true)
public class Pizza implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private final Long pizzaID;

	@NotBlank
	@Length(min = 1, max = 128)
	private String name;

	@NotBlank
	@Length(min = 1, max = 255)
	private String description;

	@NotBlank
	private Float cost;

	@NotBlank
	private Boolean isVegetarian;

	@OneToMany(mappedBy = "pizza")
	List<Toppings> toppings;

}

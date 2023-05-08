package com.timflucker.pizza.app.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder(toBuilder = true)
public class Toppings implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long toppingsID;

	@NotBlank
	@Length(min = 1, max = 32)
	private String name;

	@NotBlank
	@Length(min = 1, max = 32)
	private String description;

	@ManyToOne
	@JoinColumn(name = "pizza_id", nullable = false)
	private Pizza pizza;
}

package com.timflucker.pizza.app.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model for Pizza information. Contains list of PIZZA_TOPPINGS associated to
 * this object.
 * 
 * @author Tim Flucker
 *
 */
@Entity
@Data
@NoArgsConstructor
public class Pizza implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "PIZZA_ID")
	private Long pizzaID;

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

//	@OneToMany(mappedBy = "pizza")
	@JsonManagedReference
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "PIZZA_TOPPINGS", joinColumns = @JoinColumn(name = "PIZZA_ID"), inverseJoinColumns = @JoinColumn(name = "TOPPINGS_ID"))
	public List<Toppings> toppings;

}

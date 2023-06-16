package com.timflucker.pizza.app.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model for customer information. Each column contains validation annotations
 * to ensure that data is correct.
 * 
 * @author Tim Flucker
 *
 */
@Entity
@Data
@NoArgsConstructor
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID")
	private Long customerID;

	@NotBlank
	@Length(min = 1, max = 32)
	private String name;

	@NotBlank
	@Pattern(regexp = "(\\d{3}[- .]?){2}\\d{4}")
	@Length(min = 1, max = 15)
	private String phone;

	@NotBlank
	@Email
	@Length(min = 1, max = 128)
	private String email;

	private Boolean receivePromotions;

	public Customer(@NotBlank @Length(min = 1, max = 32) String name,
			@NotBlank @Pattern(regexp = "(\\d{3}[- .]?){2}\\d{4}") @Length(min = 1, max = 15) String phone,
			@NotBlank @Email @Length(min = 1, max = 128) String email, Boolean receivePromotions) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.receivePromotions = receivePromotions;
	}

	
	
}

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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "CUSTOMER_ID")
	private Long customerID;

	@NotBlank
	@Length(min = 1, max = 32)
	private String name;

	@NotBlank
	@Pattern(regexp = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$\r\n")
	@Length(min = 1, max = 15)
	private String phone;

	@NotBlank
	@Email
	@Length(min = 1, max = 128)
	private String email;

	@NotBlank
	private Boolean receivePromotions;

}

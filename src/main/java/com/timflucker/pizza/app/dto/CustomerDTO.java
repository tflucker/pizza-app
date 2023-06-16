package com.timflucker.pizza.app.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CustomerDTO {
	
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

}

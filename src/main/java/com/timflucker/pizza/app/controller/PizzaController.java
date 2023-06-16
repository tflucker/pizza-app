package com.timflucker.pizza.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.timflucker.pizza.app.dto.CustomerDTO;
import com.timflucker.pizza.app.dto.CustomerOrderDTO;
import com.timflucker.pizza.app.model.Customer;
import com.timflucker.pizza.app.model.Pizza;
import com.timflucker.pizza.app.service.CustomerService;
import com.timflucker.pizza.app.service.PizzaService;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;

/**
 * 
 * @author Tim Flucker
 *
 */
@RestController
@RequestMapping(value = "/pizza-app")
public class PizzaController {


	@Autowired
	private PizzaService pizzaService;

	@GetMapping("/test")
	String test() {
		return "Success!";
	}


	@GetMapping("/viewMenu")
	@ResponseBody
	List<Pizza> viewMenu() {
		return pizzaService.retrieveAllPizzas();
	}

	@PostMapping("/orderPizza")
	public String orderPizza(@RequestBody CustomerOrderDTO customerOrder) {

		String pizzaOrderId = pizzaService.orderPizza(customerOrder);

		return StringUtils.isNotBlank(pizzaOrderId) ? "Your order has been received.  Your tracking number is: " + pizzaOrderId
				: "An error has occurred. Please try again.";
	}

}

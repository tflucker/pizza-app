package com.timflucker.pizza.app.controller;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.timflucker.pizza.app.exception.DataNotFoundException;
import com.timflucker.pizza.app.exception.InvalidIdException;
import com.timflucker.pizza.app.exception.PizzaAppException;

/**
 * Exception Handler for the application. Exceptions are grouped by HttpResponse
 * status.
 * 
 * @author Tim Flucker
 *
 */
@ControllerAdvice
public class ExceptionController {

	@ResponseBody
	@ExceptionHandler(PizzaAppException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String genericException(PizzaAppException e) {
		return e.getMessage();
	}

	@ResponseBody
	@ExceptionHandler({ InvalidIdException.class, NotFoundException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String invalidRequest(Exception e) {
		return e.getMessage();
	}

	@ResponseBody
	@ExceptionHandler(DataNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String dataNotFoundExceptionHandler(DataNotFoundException e) {
		return e.getMessage();
	}
}

package com.timflucker.pizza.app.exception;

/**
 * Generic exception for the application, all custom exceptions inherit from
 * this class.
 * 
 * @author Tim Flucker
 *
 */
public class PizzaAppException extends RuntimeException {

	private static final long serialVersionUID = 2216289362555842486L;

	public PizzaAppException() {
		super();
	}

	/**
	 * Constructors which allows for custom messages to be returned.
	 * 
	 * @param message
	 */
	public PizzaAppException(String message) {
		super(message);
	}

}

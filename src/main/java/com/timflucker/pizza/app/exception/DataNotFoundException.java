package com.timflucker.pizza.app.exception;

/**
 * Custom Exception that is returned if no data is found based on the API input.
 * 
 * @author Tim Flucker
 *
 */
public class DataNotFoundException extends PizzaAppException {

	private static final long serialVersionUID = 6927107032047281627L;

	/**
	 * Constructor that returns a custom exception message with the provided ID
	 * value.
	 * 
	 * @param providedId
	 */
	public DataNotFoundException(long providedId) {
		super("No data found for the provided ID: " + providedId);
	}
	
	public DataNotFoundException(String message) {
		super(message);
	}
}

package com.timflucker.pizza.app.exception;

/**
 * Custom exception that is returned if a provided ID value is invalid (not
 * numeric).
 * 
 * @author Tim Flucker
 *
 */
public class InvalidIdException extends PizzaAppException {

	private static final long serialVersionUID = -9135768199921208511L;

	/**
	 * Constructor that returns a custom exception message with the provided ID
	 * value.
	 * 
	 * @param providedId
	 */
	public InvalidIdException(long providedId) {
		super("The provided id value (" + providedId + ") was invalid.");
	}
}

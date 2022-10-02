package com.labforward.skilltest.exception;

/**
 * @author Athul KS INFO : Custom exception class
 */
@SuppressWarnings("serial")
public class CustomException extends Exception {

	final String message;

	/**
	 * Constructor method for the class
	 */
	public CustomException(String info) {
		this.message = info;
	}

	@Override
	public String getMessage() {
		return message;
	}
}

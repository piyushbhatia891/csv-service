package com.test.kata.csv_processor.exceptions;

public class FilePathNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FilePathNotFoundException(String message) {
		super(message);
	}

}

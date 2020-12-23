package com.epam.kata.csv_processor.service;

public enum Separator {

	COMMA(','), HYPHEN('-');

	private final char separator;

	Separator(char separator) {
		this.separator = separator;
	}
	
	char getSeparator() {
		return separator;
	}

}

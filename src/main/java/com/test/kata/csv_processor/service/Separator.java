package com.test.kata.csv_processor.service;

public enum Separator implements ICustomSeparator{

	COMMA(','), HYPHEN('-');

	private final char separator;

	Separator(char separator) {
		this.separator = separator;
	}
	
	char getSeparator() {
		return separator;
	}

}

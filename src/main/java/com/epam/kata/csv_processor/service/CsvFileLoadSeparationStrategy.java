package com.epam.kata.csv_processor.service;

import java.io.IOException;
import java.util.List;

import com.epam.kata.csv_processor.models.CsvFileObject;

public abstract class CsvFileLoadSeparationStrategy implements CsvFileLoadStrategy{
	private CsvFileLoadStrategy csvFileLoadStrategy;
	public CsvFileLoadSeparationStrategy(CsvFileLoadStrategy csvFileLoadStrategy) {
		super();
		this.csvFileLoadStrategy=csvFileLoadStrategy;
	}
	
	@Override
	public List<CsvFileObject> loadFile(String path) throws IOException {
		return this.csvFileLoadStrategy.loadFile(path);
	}

}

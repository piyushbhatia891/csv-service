package com.epam.kata.csv_processor.service;

import java.io.IOException;
import java.util.List;

import com.epam.kata.csv_processor.models.CsvFileObject;

public interface CsvFileLoadStrategy {
	
	List<CsvFileObject> loadFile(String path) throws  IOException;

}

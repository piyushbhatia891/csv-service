package com.epam.kata.csv_processor.service;

import java.io.IOException;
import java.util.List;

import com.epam.kata.csv_processor.models.CsvClientFileRequest;
import com.epam.kata.csv_processor.models.CsvFileObject;

public abstract class CsvFileLoadStrategy {
	
	abstract List<CsvFileObject> loadFile(CsvClientFileRequest request) throws IOException;

}

package com.epam.kata.csv_processor.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.epam.kata.csv_processor.models.CsvClientFileRequest;
import com.epam.kata.csv_processor.models.CsvFileObject;

public interface CsvProcessorService {

	List<CsvFileObject> loadCsvFile(CsvClientFileRequest file) throws FileNotFoundException;

	boolean verifyColumnNamesHavingNullOrEmptyValues(CsvClientFileRequest csvFile) throws FileNotFoundException;

	List<CsvFileObject> loadFileAndSort(CsvClientFileRequest csvFile);
	
	boolean saveListInAFile(List<CsvFileObject> list) throws FileNotFoundException;
}

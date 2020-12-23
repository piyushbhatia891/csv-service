package com.epam.kata.csv_processor.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.epam.kata.csv_processor.models.CsvClientFileRequest;
import com.epam.kata.csv_processor.models.CsvFileObject;

public interface CsvProcessorService {

	List<CsvFileObject> loadCsvFile(CsvFileLoadStrategy strategy,CsvClientFileRequest file) throws FileNotFoundException;

	boolean verifyColumnNamesHavingNullOrEmptyValues(CsvFileLoadStrategy strategy,CsvClientFileRequest csvFile) throws FileNotFoundException;
	List<CsvFileObject> deleteRowByName(CsvFileLoadStrategy strategy,CsvClientFileRequest csvFile) throws FileNotFoundException;
	List<CsvFileObject> sortCsvFileData(CsvFileLoadStrategy strategy,CsvClientFileRequest csvFile) throws FileNotFoundException;
}

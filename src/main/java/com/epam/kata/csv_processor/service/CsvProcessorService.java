package com.epam.kata.csv_processor.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.epam.kata.csv_processor.models.CsvClientFileRequest;
import com.epam.kata.csv_processor.models.CsvFileObject;

public interface CsvProcessorService {

	List<CsvFileObject> loadCsvFile(CsvFileLoadStrategy strategy,CsvClientFileRequest file) throws FileNotFoundException;

	List<String> getColumnNamesHavingNullOrEmptyValues(CsvFileLoadStrategy strategy, CsvClientFileRequest csvFile) throws FileNotFoundException, CloneNotSupportedException;
	List<CsvFileObject> deleteRowByName(CsvFileLoadStrategy strategy,CsvClientFileRequest csvFile) throws FileNotFoundException, CloneNotSupportedException;
	List<CsvFileObject> sortCsvFileData(CsvFileLoadStrategy strategy,CsvClientFileRequest csvFile) throws FileNotFoundException;
	List<CsvFileObject> getClonedList(List<CsvFileObject> list)  throws CloneNotSupportedException;
}

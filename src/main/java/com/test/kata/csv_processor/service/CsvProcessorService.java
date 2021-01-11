package com.test.kata.csv_processor.service;

import java.util.List;

import com.test.kata.csv_processor.exceptions.CsvProcessorException;
import com.test.kata.csv_processor.models.CsvClientFileRequest;
import com.test.kata.csv_processor.models.CsvFileObject;

public interface CsvProcessorService {

	List<CsvFileObject> loadCsvFile(CsvFileLoadStrategy strategy,CsvClientFileRequest file) throws CsvProcessorException;
	List<String> getColumnNamesHavingNullOrEmptyValues(CsvFileLoadStrategy strategy, CsvClientFileRequest csvFile) throws CsvProcessorException, CloneNotSupportedException;
	List<CsvFileObject> deleteRowByName(CsvFileLoadStrategy strategy,CsvClientFileRequest csvFile) throws CsvProcessorException, CloneNotSupportedException;
	List<CsvFileObject> sortCsvFileData(CsvFileLoadStrategy strategy,CsvClientFileRequest csvFile) throws CsvProcessorException;
	List<CsvFileObject> getClonedList(List<CsvFileObject> list)  throws CloneNotSupportedException;
}

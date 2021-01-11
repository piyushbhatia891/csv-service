package com.test.kata.csv_processor.client;

import java.io.FileNotFoundException;
import java.util.List;

import com.test.kata.csv_processor.exceptions.CsvProcessorException;
import com.test.kata.csv_processor.models.CsvClientFileRequest;
import com.test.kata.csv_processor.models.CsvFileObject;
import com.test.kata.csv_processor.service.CsvFileLoadStrategy;

public interface ProcessingClient {

	List<CsvFileObject> loadCsvFile(CsvFileLoadStrategy strategy,CsvClientFileRequest csvFile) throws CsvProcessorException;
	
	List<String> getColumnNamesHavingNullOrEmptyValues(CsvFileLoadStrategy strategy,CsvClientFileRequest csvFile) throws CsvProcessorException, CloneNotSupportedException;
	
	List<CsvFileObject> deleteRowByNameAndGetRemainingEntity(CsvFileLoadStrategy strategy,CsvClientFileRequest csvFile)throws CsvProcessorException, CloneNotSupportedException;
	
	List<CsvFileObject> sortCsvFileContent(CsvFileLoadStrategy strategy,CsvClientFileRequest csvFile)throws CsvProcessorException;
	
	List<CsvFileObject> getClonedCopy(List<CsvFileObject> list) throws CloneNotSupportedException;
}

package com.epam.kata.csv_processor.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.epam.kata.csv_processor.models.CsvClientFileRequest;
import com.epam.kata.csv_processor.models.CsvFileObject;
import com.epam.kata.csv_processor.service.CsvFileLoadStrategy;
import com.epam.kata.csv_processor.service.CsvProcessorService;
import com.epam.kata.csv_processor.service.CsvProcessorServiceImpl;

public class CsvProcessorClient {

	private CsvProcessorService csvProcessorService;
	public CsvProcessorClient() {
		this.csvProcessorService=new CsvProcessorServiceImpl();
	}

	public List<CsvFileObject> loadCsvFile(CsvFileLoadStrategy strategy,CsvClientFileRequest csvFile) throws FileNotFoundException{
		return csvProcessorService.loadCsvFile(strategy,csvFile);
	}
	
	public List<String> getColumnNamesHavingNullOrEmptyValues(CsvFileLoadStrategy strategy,CsvClientFileRequest csvFile) throws FileNotFoundException, CloneNotSupportedException{
		return csvProcessorService.getColumnNamesHavingNullOrEmptyValues(strategy,csvFile);
	}
	
	public List<CsvFileObject> deleteRowByNameAndGetRemainingEntity(CsvFileLoadStrategy strategy,CsvClientFileRequest csvFile)throws FileNotFoundException, CloneNotSupportedException {
		return csvProcessorService.deleteRowByName(strategy,csvFile);
	}
	
	public List<CsvFileObject> sortCsvFileContent(CsvFileLoadStrategy strategy,CsvClientFileRequest csvFile)throws FileNotFoundException {
		return csvProcessorService.sortCsvFileData(strategy,csvFile);
	}
	
	public List<CsvFileObject> getClonedCopy(List<CsvFileObject> list) throws CloneNotSupportedException{
		return csvProcessorService.getClonedList(list);
	}
	
	

}

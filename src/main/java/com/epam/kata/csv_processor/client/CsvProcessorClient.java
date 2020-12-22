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

	public List<CsvFileObject> loadCsvFile(CsvFileLoadStrategy strategy,CsvClientFileRequest csvFile) throws FileNotFoundException {
		return csvProcessorService.loadCsvFile(strategy,csvFile);
	}
	
	public boolean getColumnNamesHavingNullOrEmptyValues(CsvFileLoadStrategy strategy,CsvClientFileRequest csvFile) throws FileNotFoundException{
		return csvProcessorService.verifyColumnNamesHavingNullOrEmptyValues(strategy,csvFile);
	}
	
	public boolean deleteRowByName(CsvFileLoadStrategy strategy,CsvClientFileRequest csvFile) throws IOException {
		return csvProcessorService.deleteRowByName(strategy,csvFile);
	}
	
	public List<CsvFileObject> sortCsvFileContent(CsvFileLoadStrategy strategy,CsvClientFileRequest csvFile) throws IOException {
		return csvProcessorService.sortCsvFileData(strategy,csvFile);
	}
	
	

}

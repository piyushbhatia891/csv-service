package com.epam.kata.csv_processor.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.kata.csv_processor.models.CsvClientFileRequest;
import com.epam.kata.csv_processor.models.CsvFileObject;
import com.epam.kata.csv_processor.service.CsvProcessorService;

public class CsvProcessorClient {

	@Autowired
	private CsvProcessorService csvProcessorService;

	public List<CsvFileObject> loadCsvFile(CsvClientFileRequest csvFile) throws FileNotFoundException {
		return csvProcessorService.loadCsvFile(csvFile);
	}
	
	public boolean getColumnNamesHavingNullOrEmptyValues(CsvClientFileRequest csvFile) throws FileNotFoundException{
		return csvProcessorService.verifyColumnNamesHavingNullOrEmptyValues(csvFile);
	}

}

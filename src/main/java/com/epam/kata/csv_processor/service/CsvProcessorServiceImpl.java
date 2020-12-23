package com.epam.kata.csv_processor.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.epam.kata.csv_processor.models.CsvClientFileRequest;
import com.epam.kata.csv_processor.models.CsvFileObject;

public class CsvProcessorServiceImpl implements CsvProcessorService {

	public List<CsvFileObject> loadCsvFile(CsvFileLoadStrategy strategy,CsvClientFileRequest csvFile) throws FileNotFoundException{
		try {
			return strategy.loadFile(csvFile);
		} catch (IOException e) {
			throw new FileNotFoundException(e.getMessage());
		}
	}

	public boolean verifyColumnNamesHavingNullOrEmptyValues(CsvFileLoadStrategy strategy,CsvClientFileRequest csvFile) throws FileNotFoundException {
		try {
			List<CsvFileObject> list = strategy.loadFile(csvFile);
			return list.stream().map(val -> {
				if (val.getName() != null)
					return val;
				else
					return null;
			}).anyMatch(val -> val == null);
		} catch (IOException e) {
			throw new FileNotFoundException(e.getMessage());
		}
	}

	@Override
	public List<CsvFileObject> deleteRowByName(CsvFileLoadStrategy strategy,CsvClientFileRequest csvFile) throws FileNotFoundException {
		try {
			List<CsvFileObject> list= strategy.loadFile(csvFile);
			list.removeAll(csvFile.getCsvObjects());
			return list;
		} catch (IOException e) {
			throw new FileNotFoundException(e.getMessage());
		}
	}
	
	public List<CsvFileObject> sortCsvFileData(CsvFileLoadStrategy strategy,CsvClientFileRequest csvFile) throws FileNotFoundException {
		try {
			return strategy.loadFile(csvFile);
			
		} catch (IOException e) {
			throw new FileNotFoundException(e.getMessage());
		}
	}


}

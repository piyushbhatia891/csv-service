package com.epam.kata.csv_processor.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.kata.csv_processor.models.CsvClientFileRequest;
import com.epam.kata.csv_processor.models.CsvFileObject;

@Service
public class CsvProcessorServiceImpl implements CsvProcessorService {

	private CsvFileLoadStrategy csvFileLoadStrategy;
	private CsvFileWriteStrategy csvFileWriteStrategy;
	@Autowired
	private CsvSortOperationImpl csvSortOperationImpl;

	public List<CsvFileObject> loadCsvFile(CsvClientFileRequest csvFile) throws FileNotFoundException {
		try {
			return processFile(csvFile);
		} catch (IOException e) {
			throw new FileNotFoundException(e.getMessage());
		}
	}

	public boolean verifyColumnNamesHavingNullOrEmptyValues(CsvClientFileRequest csvFile) throws FileNotFoundException {
		try {
			List<CsvFileObject> list = processFile(csvFile);
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
	public boolean saveListInAFile(List<CsvFileObject> list) throws FileNotFoundException {
		try {
			csvFileWriteStrategy=new WriteLocalFile();
			return csvFileWriteStrategy.createCsvFile(list);
			} catch (IOException e) {
			throw new FileNotFoundException(e.getMessage());
		}
	}


	private List<CsvFileObject> processFile(CsvClientFileRequest csvFile) throws IOException {
		getCsvFileLoadingStrategy(csvFile);
		return processCsvFile(csvFile);
	}

	private void getCsvFileLoadingStrategy(CsvClientFileRequest file) {
		String separationStrategy = file.getSeparation();
		switch (separationStrategy) {
		case "comma":
			csvFileLoadStrategy = new CommaSeparatedCSVFileLoadSeparation(new LoadLocalFile()); 
			break;
		case "space":
			csvFileLoadStrategy = new ColonSeparatedCSVFileLoadSeparation(new LoadRemoteFile());
			break;
		}

	}

	private List<CsvFileObject> processCsvFile(CsvClientFileRequest file) throws IOException {
		return csvFileLoadStrategy.loadFile(file.getFileUrl());

	}

	@Override
	public boolean deleteRowByName(CsvClientFileRequest csvFile) throws FileNotFoundException {
		try {
			List<CsvFileObject> list= processFile(csvFile);
			return list.removeIf(csvObject->csvObject.getName().equals(csvFile.getName()));
		} catch (IOException e) {
			throw new FileNotFoundException(e.getMessage());
		}
	}


}

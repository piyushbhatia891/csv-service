package com.epam.kata.csv_processor.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.epam.kata.csv_processor.exceptions.CsvProcessorException;
import com.epam.kata.csv_processor.exceptions.FilePathNotFoundException;
import com.epam.kata.csv_processor.models.CsvClientFileRequest;
import com.epam.kata.csv_processor.models.CsvFileObject;

public class CsvProcessorServiceImpl implements CsvProcessorService {

	public List<CsvFileObject> loadCsvFile(CsvFileLoadStrategy strategy, CsvClientFileRequest csvFile)
			throws CsvProcessorException {
		try {
			strategy.loadAndSortContentInAfile(csvFile);
			return strategy.list;
		} catch (IOException | FilePathNotFoundException e) {
			throw new CsvProcessorException(e.getMessage());
		}
	}

	public List<String> getColumnNamesHavingNullOrEmptyValues(CsvFileLoadStrategy strategy,
			CsvClientFileRequest csvFile) throws CsvProcessorException, CloneNotSupportedException {
		List<String> columnNamesWithEmptyOrNullValues = new ArrayList<String>();
		try {
			strategy.loadAndSortContentInAfile(csvFile);
			List<CsvFileObject> list = getClonedList(strategy.list);
			list.stream().forEach(val -> {
				if (val.getName() == null || val.getName().isEmpty())
					columnNamesWithEmptyOrNullValues.add("Name");
				else if (val.getBmi() != null)
					columnNamesWithEmptyOrNullValues.add("BMI");
				else if (val.getAge() == 0)
					columnNamesWithEmptyOrNullValues.add("Age");
			});
			return columnNamesWithEmptyOrNullValues;
		} catch (IOException | FilePathNotFoundException e) {
			throw new CsvProcessorException(e.getMessage());
		}
	}

	@Override
	public List<CsvFileObject> deleteRowByName(CsvFileLoadStrategy strategy, CsvClientFileRequest csvFile)
			throws CsvProcessorException, CloneNotSupportedException {
		try {
			strategy.loadAndSortContentInAfile(csvFile);
			List<CsvFileObject> list = getClonedList(strategy.list);
			
			if (csvFile.getCsvObjects() == null || csvFile.getCsvObjects().size() == 0) {
				list.removeIf(val -> val.getName().equals("0") || val.getAge() == 0);
			} else {
				csvFile.getCsvObjects().stream().forEach(val -> {
					switch (val) {
					case "Name":
						list.removeIf(obj -> obj.getName() == null || obj.getName().equals("0")
								|| obj.getName().equalsIgnoreCase("Na"));
						break;
					case "Age":
						list.removeIf(obj -> obj.getAge() == 0);
						break;
					}
				});
			}
			return list;
		} catch (IOException | FilePathNotFoundException e) {
			throw new CsvProcessorException(e.getMessage());
		}
	}

	public List<CsvFileObject> sortCsvFileData(CsvFileLoadStrategy strategy, CsvClientFileRequest csvFile)
			throws CsvProcessorException {
		try {
			strategy.loadAndSortContentInAfile(csvFile);
			return strategy.list;
		} catch (IOException | FilePathNotFoundException e) {
			throw new CsvProcessorException(e.getMessage());
		}
	}

	@Override
	public List<CsvFileObject> getClonedList(List<CsvFileObject> list) throws CloneNotSupportedException {
		List<CsvFileObject> clonedList = new ArrayList<>();

		Iterator<CsvFileObject> iterator = list.iterator();
		while (iterator.hasNext()) {
			clonedList.add((CsvFileObject) iterator.next().clone());
		}
		return clonedList;
	}

}

package com.epam.kata.csv_processor.service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.epam.kata.csv_processor.models.CsvClientFileRequest;
import com.epam.kata.csv_processor.models.CsvFileObject;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;

public class LoadRemoteFile extends CsvFileLoadStrategy {
	Map<String, String> mapping = new HashMap<String, String>();
	private String separation;
	private List<String> columnNamesToBeDeleted;
	private CsvCustomOperation customOperation;

	@SuppressWarnings("deprecation")
	public List<CsvFileObject> loadFile(CsvClientFileRequest request) throws IOException {
		List<CsvFileObject> list = new ArrayList<CsvFileObject>();
		Reader reader = null;
		//TODO- Changes to do here
		if (CachingServiceImpl.getCsvDataForAurl(request.getFileUrl()) == null) {
			try {
				reader = Files.newBufferedReader(Paths.get(request.getFileUrl()));
				CsvToBean<CsvFileObject> csvToBean = new CsvToBeanBuilder<CsvFileObject>(reader)
						.withType(CsvFileObject.class).withSkipLines(0)
						.withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_QUOTES).withSeparator('|').build();
				Iterator<CsvFileObject> csvUserIterator = csvToBean.iterator();
				while (csvUserIterator.hasNext()) {
					CsvFileObject csvFileObject = csvUserIterator.next();
					list.add(
							new CsvFileObject(csvFileObject.getName(), csvFileObject.getAge(), csvFileObject.getBmi()));
				}
				CachingServiceImpl.fileCache.put(request.getFileUrl(), list);

			} finally {
				reader.close();
			}
		} else {
			list = CachingServiceImpl.getCsvDataForAurl(request.getFileUrl());

		}
		if (getCustomOperation() != null)
			getCustomOperation().sortCSVListObject(list);
		return list;

	}

	/*
	 * private void setHeaderMappingStrategy() { strategy = new
	 * HeaderColumnNameTranslateMappingStrategy<CsvFileObject>();
	 * strategy.setType(CsvFileObject.class); strategy.setColumnMapping(mapping); }
	 * 
	 * private void createMappingsForCSVObject() {
	 * 
	 * mapping.put("Name", "name"); mapping.put("Age", "age"); mapping.put("BMI",
	 * "bmi"); }
	 */
	public String getSeparation() {
		return separation;
	}

	public void setSeparation(String separation) {
		this.separation = separation;
	}

	public List<String> getColumnNamesToBeDeleted() {
		return columnNamesToBeDeleted;
	}

	public void setColumnNamesToBeDeleted(List<String> columnNamesToBeDeleted) {
		this.columnNamesToBeDeleted = columnNamesToBeDeleted;
	}

	public CsvCustomOperation getCustomOperation() {
		return customOperation;
	}

	public void setCustomOperation(CsvCustomOperation customOperation) {
		this.customOperation = customOperation;
	}

}

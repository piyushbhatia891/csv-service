package com.epam.kata.csv_processor.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.kata.csv_processor.models.CsvClientFileRequest;
import com.epam.kata.csv_processor.models.CsvFileObject;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class LoadLocalFile extends CsvFileLoadStrategy {
	Map<String, String> mapping = new HashMap<String, String>();
	HeaderColumnNameTranslateMappingStrategy<CsvFileObject> strategy = null;
	private String separation;
	private List<String> columnNamesToBeDeleted;
	private CsvCustomOperation customOperation;

	public List<CsvFileObject> loadFile(CsvClientFileRequest request) {
		List<CsvFileObject> list;
		if (CachingServiceImpl.getCsvDataForAurl(request.getFileUrl()) == null) {
			createMappingsForCSVObject();
			setHeaderMappingStrategy();
			CSVReader csvReader = null;
			try {
				csvReader = new CSVReader(new FileReader(request.getFileUrl()));
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			CsvToBean csvToBean = new CsvToBean();
			 list= csvToBean.parse(strategy, csvReader);
			CachingServiceImpl.fileCache.put(request.getFileUrl(), list);
			
		} else {
			list = CachingServiceImpl.getCsvDataForAurl(request.getFileUrl());
			
		}
		if(getCustomOperation()!=null)
			getCustomOperation().sortCSVListObject(list);
		return list;

	}

	private void setHeaderMappingStrategy() {
		strategy = new HeaderColumnNameTranslateMappingStrategy<CsvFileObject>();
		strategy.setType(CsvFileObject.class);
		strategy.setColumnMapping(mapping);
	}

	private void createMappingsForCSVObject() {

		mapping.put("Name", "name");
		mapping.put("Age", "age");
		mapping.put("BMI", "bmi");
	}

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

package com.epam.kata.csv_processor.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.kata.csv_processor.models.CsvClientFileRequest;
import com.epam.kata.csv_processor.models.CsvFileObject;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class LoadRemoteFile extends CsvFileLoadStrategy {

	Map<String, String> mapping = new HashMap<String, String>();
	HeaderColumnNameTranslateMappingStrategy<CsvFileObject> strategy = null;

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

	@Override
	public List<CsvFileObject> loadFile(CsvClientFileRequest request) throws IOException {
		URL urlCSV = new URL(request.getFileUrl());
		URLConnection urlConn = urlCSV.openConnection();

		// ...
		InputStreamReader inputCSV = new InputStreamReader(((URLConnection) urlConn).getInputStream());
		// ...
		BufferedReader br = new BufferedReader(inputCSV);
		return null;

	}

}

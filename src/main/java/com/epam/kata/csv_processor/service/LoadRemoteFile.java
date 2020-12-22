package com.epam.kata.csv_processor.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.kata.csv_processor.models.CsvFileObject;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class LoadRemoteFile implements CsvFileLoadStrategy {

	Map<String, String> mapping = new HashMap<String, String>();
	HeaderColumnNameTranslateMappingStrategy strategy = null;

	public List<CsvFileObject> loadFile(String path) throws IOException {
		URL urlCSV = new URL(path);
		URLConnection urlConn = urlCSV.openConnection();

		// ...
		InputStreamReader inputCSV = new InputStreamReader(((URLConnection) urlConn).getInputStream());
		// ...
		BufferedReader br = new BufferedReader(inputCSV);
		return null;

	}

	private void setHeaderMappingStrategy() {
		strategy = new HeaderColumnNameTranslateMappingStrategy();
		strategy.setType(CsvFileObject.class);
		strategy.setColumnMapping(mapping);
	}

	private void createMappingsForCSVObject() {

		mapping.put("Name", "name");
		mapping.put("Age", "age");
		mapping.put("BMI", "bmi");
	}

}

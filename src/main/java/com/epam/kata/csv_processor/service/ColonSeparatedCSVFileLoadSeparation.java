package com.epam.kata.csv_processor.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.kata.csv_processor.models.CsvFileObject;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class ColonSeparatedCSVFileLoadSeparation extends CsvFileLoadSeparationStrategy{

	public ColonSeparatedCSVFileLoadSeparation(CsvFileLoadStrategy csvFileLoadStrategy) {
		super(csvFileLoadStrategy);
	}

	Map<String,String> mapping = new HashMap<String,String>();
	HeaderColumnNameTranslateMappingStrategy strategy=null;
	public List<CsvFileObject> loadFile(String path) {
		createMappingsForCSVObject();
		 setHeaderMappingStrategy();
		CSVReader csvReader = null;
		try {
			csvReader = new CSVReaderBuilder(new FileReader(path))
					.withCSVParser(new CSVParserBuilder().withSeparator(';') .build())
					.build();
		} catch (FileNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CsvToBean csvToBean = new CsvToBean();

		// call the parse method of CsvToBean
		// pass strategy, csvReader to parse method
		return csvToBean.parse(strategy, csvReader);
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

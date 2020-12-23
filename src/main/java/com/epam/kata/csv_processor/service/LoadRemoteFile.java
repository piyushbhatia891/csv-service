package com.epam.kata.csv_processor.service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.epam.kata.csv_processor.models.CsvClientFileRequest;
import com.epam.kata.csv_processor.models.CsvFileObject;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;

public class LoadRemoteFile extends CsvFileLoadStrategy {
	@SuppressWarnings("deprecation")
	public void loadFile(CsvClientFileRequest request) throws IOException {
		List<CsvFileObject> list = new ArrayList<CsvFileObject>();
		Reader reader = null;
		if (CachingServiceImpl.getCsvDataForAurl(request.getFileUrl())==null ) {
			try {
				reader = Files.newBufferedReader(Paths.get(request.getFileUrl()));
				CsvToBean<CsvFileObject> csvToBean = new CsvToBeanBuilder<CsvFileObject>(reader)
						.withType(CsvFileObject.class).withSkipLines(0)
						.withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_QUOTES)
						.withSeparator(separation.getSeparator()).build();
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

	@Override
	List<CsvFileObject> sortCSVListObject(List<CsvFileObject> list) {

		if (getCustomOperation() != null)
			getCustomOperation().sortCSVListObject(list);
		return list;
	}

}

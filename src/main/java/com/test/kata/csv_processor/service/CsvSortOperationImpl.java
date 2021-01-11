package com.test.kata.csv_processor.service;

import java.util.Collections;
import java.util.List;

import com.test.kata.csv_processor.models.CsvFileObject;

public class CsvSortOperationImpl implements CsvCustomOperation {

	@Override
	public List<CsvFileObject> sortCSVListObject(List<CsvFileObject> list) {
		Collections.sort(list, (o1, o2) -> o1.getAge().compareTo(o2.getAge()));
		return list;

	}
}

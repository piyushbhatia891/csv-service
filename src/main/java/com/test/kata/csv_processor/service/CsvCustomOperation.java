package com.test.kata.csv_processor.service;

import java.util.List;

import com.test.kata.csv_processor.models.CsvFileObject;

public interface CsvCustomOperation {

	List<CsvFileObject> sortCSVListObject(List<CsvFileObject> list);
}

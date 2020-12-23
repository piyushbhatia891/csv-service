package com.epam.kata.csv_processor.service;

import java.util.List;

import com.epam.kata.csv_processor.models.CsvFileObject;

public interface CsvCustomOperation {

	List<CsvFileObject> sortCSVListObject(List<CsvFileObject> list);
}

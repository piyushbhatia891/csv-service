package com.epam.kata.csv_processor.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.epam.kata.csv_processor.models.CsvFileObject;

@Service
public class CsvSortOperationImpl  implements CsvCustomOperation{

	@Override
	public List<CsvFileObject> sortCSVListObject(List<CsvFileObject> list) {
		Collections.sort(list, (o1, o2) ->
		 o1.getName().compareTo(o2.getName()));
		return list;
		  
	}
}

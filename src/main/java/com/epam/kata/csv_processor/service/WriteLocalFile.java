package com.epam.kata.csv_processor.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.epam.kata.csv_processor.models.CsvFileObject;
import com.opencsv.CSVWriter;

public class WriteLocalFile implements CsvFileWriteStrategy {

	@Override
	public boolean createCsvFile(List<CsvFileObject> list) throws IOException {
		File file = new File("");
		try (FileWriter outputfile = new FileWriter(file); CSVWriter writer = new CSVWriter(outputfile);) {

			List<String[]> fileData = new ArrayList<String[]>();
			fileData.add(new String[] { "Name", "Class", "Marks" });
			fileData.addAll(list.stream()
					.map(val -> new String[] { val.getName(), val.getAge().toString(), val.getBmi().toString() })
					.collect(Collectors.toList()));
			writer.writeAll(fileData);

		}

		return true;
	}

}

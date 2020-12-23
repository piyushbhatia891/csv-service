package com.epam.kata.csv_processor.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.epam.kata.csv_processor.client.utils.Constants;
import com.epam.kata.csv_processor.exceptions.FilePathNotFoundException;
import com.epam.kata.csv_processor.models.CsvClientFileRequest;
import com.epam.kata.csv_processor.models.CsvFileObject;

public abstract class CsvFileLoadStrategy {
	public Separator separation;
	public CsvCustomOperation customOperation;
	public List<CsvFileObject> list = new ArrayList<CsvFileObject>();

	abstract void loadFile(CsvClientFileRequest request) throws IOException;

	abstract List<CsvFileObject> sortCSVListObject(List<CsvFileObject> list);

	public final void loadAndSortContentInAfile(CsvClientFileRequest request) throws IOException {
		try {

			loadFile(request);
			sortCSVListObject(list);
		} catch (NullPointerException e) {
			throw new FilePathNotFoundException(Constants.ExceptionMessgaes.FILE_PATH_INVALID);
		}
	}

	public Separator getSeparation() {
		return separation;
	}

	public void setSeparation(Separator separation) {
		this.separation = separation;
	}

	public CsvCustomOperation getCustomOperation() {
		return customOperation;
	}

	public void setCustomOperation(CsvCustomOperation customOperation) {
		this.customOperation = customOperation;
	}

}

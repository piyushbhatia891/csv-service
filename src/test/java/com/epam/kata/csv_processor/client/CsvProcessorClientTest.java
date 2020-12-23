package com.epam.kata.csv_processor.client;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.MockitoAnnotations;

import com.epam.kata.csv_processor.BaseTest;
import com.epam.kata.csv_processor.client.utils.Constants;
import com.epam.kata.csv_processor.exceptions.CsvProcessorException;
import com.epam.kata.csv_processor.models.CsvClientFileRequest;
import com.epam.kata.csv_processor.models.CsvFileObject;
import com.epam.kata.csv_processor.service.CsvCustomOperation;
import com.epam.kata.csv_processor.service.CsvFileLoadStrategy;
import com.epam.kata.csv_processor.service.CsvSortOperationImpl;
import com.epam.kata.csv_processor.service.LoadLocalFile;
import com.epam.kata.csv_processor.service.Separator;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class CsvProcessorClientTest extends BaseTest {

	

	@After
	public void clear() {
		// CachingServiceImpl
		// TODO- clear the data from cache
	}

	@Test
	public void loadData() throws FileNotFoundException {
		List<CsvFileObject> list = client.loadCsvFile(csvFileLoadStrategy, csvClientFileRequest);
		assertThat(list.size(), is(0));
	}

	@Test
	public void loadDataForInvalidFile() throws FileNotFoundException {
		expectedEx.expect(CsvProcessorException.class);
	    expectedEx.expectMessage(Constants.ExceptionMessgaes.FILE_PATH_INVALID);
		csvClientFileRequest.setFileUrl("");
		client.loadCsvFile(csvFileLoadStrategy, csvClientFileRequest);
	}

	@Test
	public void getColumnNamesHavingNullOrEmptyValues() throws CsvProcessorException, CloneNotSupportedException {
		List<String> list = client.getColumnNamesHavingNullOrEmptyValues(csvFileLoadStrategy, csvClientFileRequest);
		assertThat(list.size(), is(0));
	}
	
	@Test
	public void getClonedCopy() throws CsvProcessorException, CloneNotSupportedException {
		List<CsvFileObject> list = client.getClonedCopy(csvList);
		assertThat(list.size(), is(2));
	}
	
	@Test
	public void deletRowByNameAndGetEntity() throws FileNotFoundException, CloneNotSupportedException {
		csvClientFileRequest.setColumnNames(csvFileObjects);
		List<CsvFileObject> list = client.deleteRowByNameAndGetRemainingEntity(csvFileLoadStrategy,
				csvClientFileRequest);
		assertThat(0, is(list.size()));
	}

	@Test
	public void sortCsvFileContentByAge() throws FileNotFoundException {
		csvClientFileRequest.setColumnNames(csvFileObjects);
		List<CsvFileObject> list = client.sortCsvFileContent(csvFileLoadStrategy, csvClientFileRequest);
		assertThat(list.size(), is(0));
	}
}

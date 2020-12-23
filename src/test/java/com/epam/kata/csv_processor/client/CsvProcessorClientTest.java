package com.epam.kata.csv_processor.client;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.kata.csv_processor.models.CsvClientFileRequest;
import com.epam.kata.csv_processor.models.CsvFileObject;
import com.epam.kata.csv_processor.service.CachingServiceImpl;
import com.epam.kata.csv_processor.service.CsvCustomOperation;
import com.epam.kata.csv_processor.service.CsvProcessorService;
import com.epam.kata.csv_processor.service.CsvSortOperationImpl;
import com.epam.kata.csv_processor.service.LoadLocalFile;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
public class CsvProcessorClientTest {
	
	@InjectMocks
	CsvProcessorClient client;
	@Mock
	private CsvProcessorService csvProcessorService;
	LoadLocalFile csvFileLoadStrategy;
	CsvCustomOperation csvCustomOperation;
	CsvClientFileRequest csvClientFileRequest;
	List<String> csvFileObjects=new ArrayList();
	
	@Before
	public void setSup() {
		MockitoAnnotations.initMocks(this);
		csvClientFileRequest=new CsvClientFileRequest();
		csvClientFileRequest.setFileUrl("D:\\files\\diabetes.csv");
		csvFileObjects.add("Name");
		client=new CsvProcessorClient();
		csvCustomOperation=new CsvSortOperationImpl();
		csvFileLoadStrategy=new LoadLocalFile();
		csvFileLoadStrategy.setCustomOperation(null);
		csvFileLoadStrategy.setSeparation(",");
	}
	
	@After
	public void clear() {
		//CachingServiceImpl
		//TODO- clear the data from cache
	}

	@Test
	public void loadData() throws FileNotFoundException {
		List<CsvFileObject> list=client.loadCsvFile(csvFileLoadStrategy, csvClientFileRequest);
		assertThat(768, is(list.size()));
	}
	
	@Test(expected = FileNotFoundException.class)
	public void loadDataForInvalidFile() throws FileNotFoundException {
		csvClientFileRequest.setFileUrl("");
		client.loadCsvFile(csvFileLoadStrategy, csvClientFileRequest);
	}
	
	@Test
	public void deletRowByNameAndGetEntity() throws FileNotFoundException, CloneNotSupportedException {
		csvClientFileRequest.setCsvObjects(csvFileObjects);
		List<CsvFileObject> list=client.deleteRowByNameAndGetRemainingEntity(csvFileLoadStrategy,  csvClientFileRequest);
		assertThat(0, is(list.size()));
	}
	
	@Test
	public void sortCsvFileContentByName() throws FileNotFoundException {
		csvClientFileRequest.setCsvObjects(csvFileObjects);
		List<CsvFileObject> list=client.sortCsvFileContent(csvFileLoadStrategy,  csvClientFileRequest);
		assertThat(768, is(list.size()));
	}
}

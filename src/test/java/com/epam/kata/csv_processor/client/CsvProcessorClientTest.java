package com.epam.kata.csv_processor.client;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.kata.csv_processor.models.CsvClientFileRequest;
import com.epam.kata.csv_processor.models.CsvFileObject;
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
	List<CsvFileObject> csvFileObjects;
	
	@Before
	public void setSup() {
		MockitoAnnotations.initMocks(this);
		csvClientFileRequest=new CsvClientFileRequest();
		csvClientFileRequest.setFileUrl("test");
		csvClientFileRequest.setCsvObjects(new ArrayList<CsvFileObject>());
		CsvFileObject csvFileObject=new CsvFileObject();
		csvFileObject.setName("Piyush");
		csvFileObject.setBmi(12);
		csvFileObject.setAge(11);
		csvFileObjects.add(csvFileObject);
		client=new CsvProcessorClient();
		csvCustomOperation=new CsvSortOperationImpl();
		csvFileLoadStrategy=new LoadLocalFile();
		csvFileLoadStrategy.setCustomOperation(csvCustomOperation);
		csvFileLoadStrategy.setSeparation(",");
	}

	@Test
	public void loadData() throws FileNotFoundException {
		when(client.loadCsvFile(csvFileLoadStrategy, csvClientFileRequest)).thenReturn(new ArrayList<CsvFileObject>());
		List<CsvFileObject> list=client.loadCsvFile(csvFileLoadStrategy, csvClientFileRequest);
		assertThat(1, is(list.size()));
	}
	
	@Test(expected = FileNotFoundException.class)
	public void loadDataForInvalidFile() throws FileNotFoundException {
		when(client.loadCsvFile(csvFileLoadStrategy, csvClientFileRequest)).thenReturn(new ArrayList<CsvFileObject>());
		List<CsvFileObject> list=client.loadCsvFile(csvFileLoadStrategy, csvClientFileRequest);
		assertThat(1, is(list.size()));
	}
	
	@Test
	public void deletRowByNameAndGetEntity() throws FileNotFoundException {
		csvClientFileRequest.setCsvObjects(csvFileObjects);
		when(client.deleteRowByNameAndGetRemainingEntity(csvFileLoadStrategy,  csvClientFileRequest)).thenReturn(new ArrayList<CsvFileObject>());
		List<CsvFileObject> list=client.deleteRowByNameAndGetRemainingEntity(csvFileLoadStrategy,  csvClientFileRequest);
		assertThat(1, is(list.size()));
	}
	
	@Test
	public void sortCsvFileContentByName() throws FileNotFoundException {
		csvClientFileRequest.setCsvObjects(csvFileObjects);
		when(client.sortCsvFileContent(csvFileLoadStrategy,  csvClientFileRequest)).thenReturn(new ArrayList<CsvFileObject>());
		List<CsvFileObject> list=client.sortCsvFileContent(csvFileLoadStrategy,  csvClientFileRequest);
		assertThat(1, is(list.size()));
	}
}

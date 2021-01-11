package com.test.kata.csv_processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.mockito.MockitoAnnotations;

import com.test.kata.csv_processor.client.CsvProcessorClient;
import com.test.kata.csv_processor.client.ProcessingClient;
import com.test.kata.csv_processor.client.utils.Constants;
import com.test.kata.csv_processor.models.CsvClientFileRequest;
import com.test.kata.csv_processor.models.CsvFileObject;
import com.test.kata.csv_processor.service.CsvCustomOperation;
import com.test.kata.csv_processor.service.CsvFileLoadStrategy;
import com.test.kata.csv_processor.service.CsvSortOperationImpl;
import com.test.kata.csv_processor.service.LoadLocalFile;
import com.test.kata.csv_processor.service.Separator;

public class BaseTest {

	protected ProcessingClient client;
	protected CsvFileLoadStrategy csvFileLoadStrategy;
	protected CsvCustomOperation csvCustomOperation;
	protected CsvClientFileRequest csvClientFileRequest;
	protected List<String> csvFileObjects = new ArrayList<String>();
	protected List<CsvFileObject> csvList=new ArrayList<CsvFileObject>();

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	@Before
	public void setSup() {
		MockitoAnnotations.initMocks(this);
		csvFileObjects.add("Name");
		csvClientFileRequest = new CsvClientFileRequest.CsvClientFileRequestBuilder(Constants.FILE_PATH)
				.withColumnNames(csvFileObjects).build();

		client = new CsvProcessorClient();
		csvCustomOperation = new CsvSortOperationImpl();
		csvFileLoadStrategy = new LoadLocalFile();
		csvFileLoadStrategy.setCustomOperation(null);
		csvFileLoadStrategy.setSeparation(Separator.COMMA);
		for(int i=2;i>0;i--) {
			CsvFileObject obj=new CsvFileObject();
			obj.setAge(i);
			obj.setName("piyush");
			obj.setBmi(1);
			csvList.add(obj);
		}
	}
}

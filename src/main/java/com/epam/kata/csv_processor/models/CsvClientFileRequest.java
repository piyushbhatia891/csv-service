package com.epam.kata.csv_processor.models;

import java.util.List;

public class CsvClientFileRequest {
	
	private String fileUrl;
	private List<String> columnNames;
	
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public void setColumnNames(List<String> columnNames) {
		this.columnNames = columnNames;
	}
	public CsvClientFileRequest(CsvClientFileRequestBuilder csvClientFileRequestBuilder) {
		this.fileUrl=csvClientFileRequestBuilder.fileUrl;
		this.columnNames=csvClientFileRequestBuilder.columnNames;
	}
	public static class CsvClientFileRequestBuilder{
		private String fileUrl;
		private List<String> columnNames;
		public CsvClientFileRequestBuilder(String fileUrl) {
			this.fileUrl=fileUrl;
		}
		
		public CsvClientFileRequestBuilder withColumnNames(List<String> columnNames) {
			this.columnNames=columnNames;
			return this;
		}
		
		public CsvClientFileRequest build() {
			return new CsvClientFileRequest(this);
		}
		
	}
	
	public List<String> getCsvObjects() {
		return columnNames;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	
}

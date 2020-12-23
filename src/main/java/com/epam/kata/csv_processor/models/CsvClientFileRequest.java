package com.epam.kata.csv_processor.models;

import java.util.List;

public class CsvClientFileRequest {
	
	private String fileUrl;
	private boolean isLocal;
	private List<String> csvObjects;
	private String separator;
	
	
	
	
	public String getSeparator() {
		return separator;
	}
	public void setSeparator(String separator) {
		this.separator = separator;
	}
	public List<String> getCsvObjects() {
		return csvObjects;
	}
	public void setCsvObjects(List<String> csvObjects) {
		this.csvObjects = csvObjects;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public boolean isLocal() {
		return isLocal;
	}
	public void setLocal(boolean isLocal) {
		this.isLocal = isLocal;
	}
	

}

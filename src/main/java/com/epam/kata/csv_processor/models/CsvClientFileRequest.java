package com.epam.kata.csv_processor.models;

import java.util.List;

import org.springframework.lang.NonNull;

public class CsvClientFileRequest {
	
	private String fileUrl;
	private boolean isLocal;
	private List<CsvFileObject> csvObjects;
	
	
	
	public List<CsvFileObject> getCsvObjects() {
		return csvObjects;
	}
	public void setCsvObjects(List<CsvFileObject> csvObjects) {
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

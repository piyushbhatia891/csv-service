package com.epam.kata.csv_processor.models;

import org.springframework.lang.NonNull;

public class CsvClientFileRequest {
	
	private String fileUrl;
	private boolean isLocal;
	private String separation;
	private String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSeparation() {
		return separation;
	}
	public void setSeparation(String separation) {
		this.separation = separation;
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

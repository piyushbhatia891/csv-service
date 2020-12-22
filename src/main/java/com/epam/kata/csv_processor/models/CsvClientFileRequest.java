package com.epam.kata.csv_processor.models;

import org.springframework.lang.NonNull;

public class CsvClientFileRequest {
	
	private String fileUrl;
	private boolean isLocal;
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

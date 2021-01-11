package com.test.kata.csv_processor.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.kata.csv_processor.models.*;
public class CachingServiceImpl {
	
	static Map<String,List<CsvFileObject>> fileCache=new HashMap<String, List<CsvFileObject>>();
	
	static void addObjectInCache(String fileUrl,List<CsvFileObject> list) {
		fileCache.put(fileUrl, list);
	}
	
	
	static List<CsvFileObject> getCsvDataForAurl(String url){
		return fileCache.containsKey(url) ? fileCache.get(url):null;
	}

}

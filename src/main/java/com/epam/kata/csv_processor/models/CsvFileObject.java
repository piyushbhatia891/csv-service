package com.epam.kata.csv_processor.models;

import com.opencsv.bean.CsvBindByName;

public class CsvFileObject implements Cloneable {
	@CsvBindByName(column = "Name")
	private String name;
	@CsvBindByName(column = "Age")
	private Integer age;
	@CsvBindByName(column = "BMI")
	private Object bmi;

	public CsvFileObject(String name, Integer age, Object bmi) {
		super();
		this.name = name;

		this.age = age;
		this.bmi = bmi;
	}
	
	 @Override
	public Object clone() throws CloneNotSupportedException {
		 CsvFileObject clone = null;
	        try
	        {
	            clone = (CsvFileObject) super.clone();
	        } 
	        catch (CloneNotSupportedException e) 
	        {
	            throw new RuntimeException(e);
	        }
	        return clone;
	    }

	public CsvFileObject() {
		
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Object getBmi() {
		return bmi;
	}

	public void setBmi(Object bmi) {
		this.bmi = bmi;
	}

}

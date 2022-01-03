package com.spring.rest.model;

import java.util.Arrays;
import java.util.List;

public class DataModel {
	
	private DataModel() {
		
	}
	
	public static List<Student> getStudents() {
		return Arrays.asList(
				new Student(1, "John", "Terry"),
				new Student(2, "Ricardo", "Kaka"),
				new Student(3, "Alexander", "Pato")
		);
	}
}

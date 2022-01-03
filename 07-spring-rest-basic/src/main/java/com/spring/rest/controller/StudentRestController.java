package com.spring.rest.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.exception.handler.ItemNotFoundException;
import com.spring.rest.model.DataModel;
import com.spring.rest.model.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> students;
	
	@PostConstruct
	public void loading() {
		students = DataModel.getStudents();
	}
	
	
	// end point: http://localhost:8080/07-spring-rest-basic/api/students
	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}
	
	// end point: http://localhost:8080/07-spring-rest-basic/api/students/123
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		Optional<Student> opt = students.stream()
					   .filter(student -> studentId == student.getId())
					   .findFirst();
		
		if (!opt.isPresent()) {
			throw new ItemNotFoundException("student not found " + studentId);
		}
		
		return opt.get();
	}
}

package com.jspiders.springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springrest.pojo.StudentPOJO;
import com.jspiders.springrest.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;

	public StudentPOJO add(StudentPOJO student) {
		StudentPOJO pojo = repository.add(student);
		return pojo;
	}

	public StudentPOJO search(int id) {
		StudentPOJO student = repository.search(id);
		return student;
	}

}

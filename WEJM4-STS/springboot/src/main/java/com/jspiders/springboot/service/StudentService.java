package com.jspiders.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springboot.pojo.StudentPOJO;
import com.jspiders.springboot.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;

	public StudentPOJO add(StudentPOJO student) {
		StudentPOJO pojo = repository.save(student);
		return pojo;
	}

	public StudentPOJO searchById(int id) {
		StudentPOJO student = repository.findById(id).orElse(null);
		return student;
	}

	public StudentPOJO searchByName(String name) {
		StudentPOJO student = repository.findByName(name);
		return student;
	}

}

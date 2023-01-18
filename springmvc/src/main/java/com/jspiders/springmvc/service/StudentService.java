package com.jspiders.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvc.pojo.StudentPOJO;
import com.jspiders.springmvc.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;

	public StudentPOJO add(String name, String email, 
							long contact, String city, String username, String password) {
		StudentPOJO student = repository.add(name, email, contact, city, username, password);
		return student;
	}
	
	public StudentPOJO login(String username, String password) {
		StudentPOJO student = repository.login(username, password);
		return student;
	}

}

package com.jspiders.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springrest.pojo.StudentPOJO;
import com.jspiders.springrest.response.StudentResponse;
import com.jspiders.springrest.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	public void addStudent(@RequestBody StudentPOJO student) {
		StudentPOJO pojo = service.add(student);
		StudentResponse response = new StudentResponse();
		if (pojo != null) {
			//success
			response.setStatus("SUCCESS");
			response.setDescription("Student added successfully..!!");
			response.setData(pojo);
		}
		//failure
		response.setStatus("FAILURE");
		response.setDescription("Student not added..!!");
	}

}

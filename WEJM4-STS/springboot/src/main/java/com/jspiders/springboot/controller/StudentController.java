package com.jspiders.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springboot.pojo.StudentPOJO;
import com.jspiders.springboot.response.StudentResponse;
import com.jspiders.springboot.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("/add")
	public ResponseEntity<StudentResponse> 
						add(@RequestBody StudentPOJO student) {
		StudentPOJO pojo = service.add(student);
		if (pojo != null) {
			//success
			return new ResponseEntity<StudentResponse>
			(new StudentResponse("SUCCESS", "Student added successfully", 
					pojo, null), HttpStatus.ACCEPTED);
		}
		//failure
		return new ResponseEntity<StudentResponse>
		(new StudentResponse("FAILED", "Student not addedd", 
				null, null), HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<StudentResponse> search(@PathVariable int id){
		StudentPOJO student = service.searchById(id);
		if (student != null) {
			//success
			return new ResponseEntity<StudentResponse>
			(new StudentResponse("FOUND", "Student data found successfully", 
					student, null), HttpStatus.FOUND);
		}
		//failure
		return new ResponseEntity<StudentResponse>
		(new StudentResponse("NOT FOUND", "Student data not found", 
				null, null), HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/searchByName")
	public ResponseEntity<StudentResponse> 
			searchByName(@RequestParam String name){
		StudentPOJO student = service.searchByName(name);
		if (student != null) {
			//success
			return new ResponseEntity<StudentResponse>
			(new StudentResponse("FOUND", "Student data found successfully", 
					student, null), HttpStatus.FOUND);
		}
		//failure
		return new ResponseEntity<StudentResponse>
		(new StudentResponse("NOT FOUND", "Student data not found", 
				null, null), HttpStatus.NOT_FOUND);
	}

}

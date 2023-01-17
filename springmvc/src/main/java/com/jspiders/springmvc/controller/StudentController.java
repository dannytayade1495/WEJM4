package com.jspiders.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.pojo.StudentPOJO;
import com.jspiders.springmvc.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	//Home controller
	@GetMapping("/home")
	public String home() {
		return "Home";
	}
	
	//Add Form controller
	@GetMapping("/add")
	public String add() {
		return "Add";
	}
	
	//Add response controller
	@PostMapping("/add")
	public String addStudent(@RequestParam String name,
							@RequestParam String email,
							@RequestParam long contact,
							@RequestParam String city, ModelMap map) {
		StudentPOJO student = service.add(name, email,
										contact, city);
		if(student != null) {
			map.addAttribute("student", student);
			map.addAttribute("msg", "Student added successfully..!!");
		} else {
			map.addAttribute("msg", "Student not added..!!");
		}
		return "Add";
	}
	
	//Search form controller
	@GetMapping("/search")
	public String search() {
		return "Search";
	}
	
	//Remove form controller
	@GetMapping("/remove")
	public String remove() {
		return "Remove";
	}
	
	//Update form controller
	@GetMapping("/update")
	public String update() {
		return "Update";
	}
	
	//logout controller
	@GetMapping("/logout")
	public String logout() {
		return "Login";
	}

}

package com.jspiders.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.pojo.StudentPOJO;
import com.jspiders.springmvc.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	// Home controller
	@GetMapping("/home")
	public String home() {
		return "Home";
	}

	// Login Form Controller
	@GetMapping("/login")
	public String login() {
		return "Login";
	}

	// Login controller
	@PostMapping("/login")
	public String loginData(@RequestParam String username, @RequestParam String password, ModelMap map) {
		StudentPOJO student = service.login(username, password);
		if (student != null) {
			return "Home";
		}
		map.addAttribute("msg", "Invalid username or password..!!");
		return "Login";
	}

	// Add Form controller
	@GetMapping("/add")
	public String add() {
		return "Add";
	}

	// Add response controller
	@PostMapping("/add")
	public String addStudent(@RequestParam String name, @RequestParam String email, @RequestParam long contact,
			@RequestParam String city, @RequestParam String username, @RequestParam String password, ModelMap map) {
		StudentPOJO student = service.add(name, email, contact, city, username, password);
		if (student != null) {
			map.addAttribute("student", student);
			map.addAttribute("msg", "Student added successfully..!!");
		} else {
			map.addAttribute("msg", "Student not added..!!");
		}
		return "Add";
	}

	// Search form controller
	@GetMapping("/search")
	public String search() {
		return "Search";
	}

	// Search response controller
	@PostMapping("/search")
	public String searchData(@RequestParam int id, ModelMap map) {
		StudentPOJO student = service.search(id);
		if (student != null) {
			// success
			map.addAttribute("student", student);
			return "Search";
		}
		// failure
		map.addAttribute("msg", "Student data does not exist..!!");
		return "Search";
	}

	// Remove form controller
	@GetMapping("/remove")
	public String remove(ModelMap map) {
		List<StudentPOJO> students = service.searchAll();
		map.addAttribute("students", students);
		return "Remove";
	}

	// Remove response controller
	@PostMapping("/remove")
	public String removeData(@RequestParam int id, ModelMap map) {
		StudentPOJO student = service.remove(id);
		if (student != null) {
			// success
			List<StudentPOJO> students = service.searchAll();
			map.addAttribute("students", students);
			map.addAttribute("msg", "Student removed successfully..!!");
			return "Remove";
		}
		// failure
		List<StudentPOJO> students = service.searchAll();
		map.addAttribute("students", students);
		map.addAttribute("msg", "Student data does not exist..!!");
		return "Remove";
	}

	// Update page controller
	@GetMapping("/update")
	public String update(ModelMap map) {
		List<StudentPOJO> students = service.searchAll();
		map.addAttribute("students", students);
		return "Update";
	}
	
	// Update form controller
	@PostMapping("/update")
	public String updateForm(@RequestParam int id, ModelMap map) {
		StudentPOJO student = service.search(id);
		if (student != null) {
			//success
			map.addAttribute("student", student);
		}
		//failure
		List<StudentPOJO> students = service.searchAll();
		map.addAttribute("students", students);
		map.addAttribute("msg", "Student data does not exist..!!");
		return "Update";
	}
	
	// Update Data controller
	@PostMapping("/updateData")
	public String updateData(@RequestParam int id, @RequestParam String name, @RequestParam String email, @RequestParam long contact,
			@RequestParam String city, @RequestParam String username, @RequestParam String password, ModelMap map) {
		StudentPOJO student = service.update(id, name, email, contact, city, username, password);
		if (student != null) {
			//success
			map.addAttribute("msg", "Student data updated successfully..!!");
			List<StudentPOJO> students = service.searchAll();
			map.addAttribute("students", students);
			return "Update";
		}
		//failure
		map.addAttribute("msg", "Student not updated..!!");
		List<StudentPOJO> students = service.searchAll();
		map.addAttribute("students", students);
		return "Update";
	}

	// logout controller
	@GetMapping("/logout")
	public String logout() {
		return "Login";
	}

}

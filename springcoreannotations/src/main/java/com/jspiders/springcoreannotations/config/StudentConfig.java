package com.jspiders.springcoreannotations.config;

import org.springframework.context.annotation.Bean;

import com.jspiders.springcoreannotations.beans.StudentBean;

public class StudentConfig {
	
	@Bean("student")
	public StudentBean getStudent() {
		StudentBean student = new StudentBean();
		student.setId(1);
		student.setName("Avinash");
		student.setEmail("avinash@gmail.com");
		student.setCity("Bangalore");
		return student;
	}
	
	@Bean("student1")
	public StudentBean getSudent1() {
		return new StudentBean(2, "Aishwarya", 
				"aishwarya@gmail.com", "Mumbai");
	}
	
	@Bean("student2")
	public StudentBean getStudent2() {
		return new StudentBean();
	}

}

package com.jspiders.springcoreannotations.beans;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentBean {
	
	@Value("3")
	private int id;
	
	@Value("Karan")
	private String name;
	
	@Value("karan@gmail.com")
	private String email;
	
	@Value("Pune")
	private String city;

}

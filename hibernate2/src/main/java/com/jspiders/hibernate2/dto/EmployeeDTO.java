package com.jspiders.hibernate2.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "emp")
public class EmployeeDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "ename")
	private String name;
	
	@Column(name = "mail_id")
	private String email;
	
	@Column(name = "job")
	private String designation;
	
	@Column(name = "sal")
	private double salary;

}

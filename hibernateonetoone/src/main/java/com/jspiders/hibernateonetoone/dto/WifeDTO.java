package com.jspiders.hibernateonetoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class WifeDTO {
	
	@Id
	int id;
	String name;
	int age;

}

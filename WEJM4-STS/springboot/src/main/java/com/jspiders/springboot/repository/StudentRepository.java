package com.jspiders.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.springboot.pojo.StudentPOJO;

public interface StudentRepository extends JpaRepository<StudentPOJO, Integer>{
	
	StudentPOJO findByName(String name);

}

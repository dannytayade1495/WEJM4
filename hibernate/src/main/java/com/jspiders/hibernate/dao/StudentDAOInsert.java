package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.StudentDTO;

public class StudentDAOInsert {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory
											("student");
		
		EntityManager entityManager = 
				entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction = 
				entityManager.getTransaction();
		
		entityTransaction.begin();
		
		StudentDTO student = new StudentDTO();
		student.setId(1);
		student.setName("Popatlal");
		student.setEmail("popatlal@matrimony.com");
		student.setContact(9876543210L);
		student.setCity("Gokuldham");
		
		entityManager.persist(student);
		
		entityTransaction.commit();
		
		entityManagerFactory.close();
		entityManager.close();
		
	}

}

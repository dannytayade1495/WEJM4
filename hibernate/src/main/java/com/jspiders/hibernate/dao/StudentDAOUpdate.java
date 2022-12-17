package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.StudentDTO;

public class StudentDAOUpdate {
	
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("student");

		EntityManager entityManager = 
				entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = 
				entityManager.getTransaction();

		entityTransaction.begin();

		StudentDTO student = 
				entityManager.find(StudentDTO.class, 1);

		student.setEmail("popatlal@gmail.com");
		
		entityManager.persist(student);

		entityTransaction.commit();

		entityManagerFactory.close();
		entityManager.close();

	}

}

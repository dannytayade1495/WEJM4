package com.jspiders.hibernateonetomany.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernateonetomany.dto.ChildDTO;
import com.jspiders.hibernateonetomany.dto.FatherDTO;

public class FatherChildDAO {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.
				createEntityManagerFactory("OneToMany");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}
	
	public static void main(String[] args) {
		
		openConnection();
		transaction.begin();
		
		ChildDTO child1 = new ChildDTO();
		child1.setId(1);
		child1.setName("Suresh");
		child1.setAge(20);
		manager.persist(child1);
		
		ChildDTO child2 = new ChildDTO();
		child2.setId(2);
		child2.setName("Mukesh");
		child2.setAge(25);
		manager.persist(child2);
		
		List<ChildDTO> children = 
				Arrays.asList(child1, child2);
		
		FatherDTO father1 = new FatherDTO();
		father1.setId(1);
		father1.setName("Ramesh");
		father1.setAge(50);
		father1.setChildren(children);
		manager.persist(father1);
		
		transaction.commit();
		closeConnection();
		
	}

}

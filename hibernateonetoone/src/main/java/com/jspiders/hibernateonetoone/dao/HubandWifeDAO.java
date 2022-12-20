package com.jspiders.hibernateonetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernateonetoone.dto.HusbandDTO;
import com.jspiders.hibernateonetoone.dto.WifeDTO;

public class HubandWifeDAO {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.
				createEntityManagerFactory("OneToOne");
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
		
		WifeDTO wife1 = new WifeDTO();
		wife1.setId(1);
		wife1.setName("Daya");
		wife1.setAge(35);
		manager.persist(wife1);
		
		HusbandDTO husband1 = new HusbandDTO();
		husband1.setId(1);
		husband1.setName("Jethalal");
		husband1.setAge(40);
		husband1.setWife(wife1);
		manager.persist(husband1);
		
		transaction.commit();
		closeConnection();
		
	}

}

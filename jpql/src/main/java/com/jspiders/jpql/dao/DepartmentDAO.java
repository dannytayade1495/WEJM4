package com.jspiders.jpql.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.jpql.dto.DepartmentDTO;

public class DepartmentDAO {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	private static String jpqlQuery;
	private static int result;

	private static void openConnection() {
		factory = Persistence.
				createEntityManagerFactory("jpql");
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
		
		jpqlQuery = "from DepartmentDTO";
		
		query = manager.createQuery(jpqlQuery);
		List<DepartmentDTO> resultList = query.getResultList();
		
		for (DepartmentDTO dept : resultList) {
			System.out.println(dept);
		}
		
		jpqlQuery = "update DepartmentDTO "
					+ "set location = 'Bangalore' "
					+ "where id=4";
		
		query = manager.createQuery(jpqlQuery);
		result = query.executeUpdate();
		
		System.out.println(result + " row(s) affected");
		
		jpqlQuery = "delete from DepartmentDTO "
					+ "where id=4";
	
		query = manager.createQuery(jpqlQuery);
		result = query.executeUpdate();
	
		System.out.println(result + " row(s) affected");
		
		transaction.commit();
		closeConnection();
	}

}

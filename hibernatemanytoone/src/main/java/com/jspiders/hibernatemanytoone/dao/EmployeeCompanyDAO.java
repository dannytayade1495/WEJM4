package com.jspiders.hibernatemanytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernatemanytoone.dto.CompanyDTO;
import com.jspiders.hibernatemanytoone.dto.EmployeeDTO;

public class EmployeeCompanyDAO {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.
				createEntityManagerFactory("ManyToOne");
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
		
		CompanyDTO company = new CompanyDTO();
		company.setId(1);
		company.setName("Capgemini");
		company.setCity("Pune");
		manager.persist(company);
		
		EmployeeDTO employee1 = new EmployeeDTO();
		employee1.setId(1);
		employee1.setName("Amar");
		employee1.setEmail("amar@capgemini.com");
		employee1.setSalary(30000);
		employee1.setCompany(company);
		manager.persist(employee1);

		EmployeeDTO employee2 = new EmployeeDTO();
		employee2.setId(2);
		employee2.setName("Akbar");
		employee2.setEmail("akbar@capgemini.com");
		employee2.setSalary(35000);
		employee2.setCompany(company);
		manager.persist(employee2);
		
		EmployeeDTO employee3 = new EmployeeDTO();
		employee3.setId(3);
		employee3.setName("Anthony");
		employee3.setEmail("anthony@capgemini.com");
		employee3.setSalary(32000);
		employee3.setCompany(company);
		manager.persist(employee3);
		
		transaction.commit();
		closeConnection();
	}

}

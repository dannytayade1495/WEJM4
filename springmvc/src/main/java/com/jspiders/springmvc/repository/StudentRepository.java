package com.jspiders.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springmvc.pojo.StudentPOJO;

@Repository
public class StudentRepository {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static String jpql;
	private static Query query;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("WEJM4MVC");
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

	public StudentPOJO add(String name, String email, long contact, String city, String username, String password) {
		openConnection();
		transaction.begin();
		StudentPOJO pojo = new StudentPOJO();
		pojo.setName(name);
		pojo.setEmail(email);
		pojo.setContact(contact);
		pojo.setCity(city);
		pojo.setUsername(username);
		pojo.setPassword(password);
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
	}

	public StudentPOJO login(String username, String password) {
		openConnection();
		transaction.begin();
		jpql = "from StudentPOJO " + "where username = '" + username + "' " + "and password = '" + password + "'";
		query = manager.createQuery(jpql);
		List<StudentPOJO> resultList = query.getResultList();
		for (StudentPOJO student : resultList) {
			transaction.commit();
			closeConnection();
			return student;
		}
		transaction.commit();
		closeConnection();
		return null;
	}

	public StudentPOJO search(int id) {
		openConnection();
		transaction.begin();
		StudentPOJO student = manager.find(StudentPOJO.class, id);
		if (student != null) {
			transaction.commit();
			closeConnection();
			return student;
		}
		transaction.commit();
		closeConnection();
		return null;
	}

	public List<StudentPOJO> searchAll() {
		openConnection();
		transaction.begin();
		jpql = "from StudentPOJO";
		query = manager.createQuery(jpql);
		List<StudentPOJO> students = query.getResultList();
		transaction.commit();
		closeConnection();
		return students;
	}

	public StudentPOJO remove(int id) {
		openConnection();
		transaction.begin();
		StudentPOJO student = manager.find(StudentPOJO.class, id);
		if (student != null) {
			manager.remove(student);
		}
		transaction.commit();
		closeConnection();
		return student;
	}

	public StudentPOJO update(int id, String name, String email, long contact, String city, String username,
			String password) {
		openConnection();
		transaction.begin();
		StudentPOJO student = manager.find(StudentPOJO.class, id);
		if (student != null) {
			student.setName(name);
			student.setEmail(email);
			student.setContact(contact);
			student.setCity(city);
			student.setUsername(username);
			student.setPassword(password);
			manager.persist(student);
			transaction.commit();
			closeConnection();
			return student;
		}
		transaction.commit();
		closeConnection();
		return null;
	}

}

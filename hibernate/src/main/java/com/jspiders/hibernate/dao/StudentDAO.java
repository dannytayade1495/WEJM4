package com.jspiders.hibernate.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.StudentDTO;

public class StudentDAO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Scanner scanner;
	private static int id;
	private static String name;
	private static String email;
	private static long contact;
	private static String city;
	private static int choice;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("student");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		scanner = new Scanner(System.in);
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

	public static void insert() {
		openConnection();
		
		System.out.println("How many records you want to insert?");
		choice = scanner.nextInt();
		for (int i = 1; i <= choice; i++) {
			
			transaction.begin();
			
			StudentDTO student = new StudentDTO();

			System.out.println("Enter the student id: ");
			id = scanner.nextInt();
			student.setId(id);

			System.out.println("Enter the student name: ");
			name = scanner.next();
			student.setName(name);

			System.out.println("Enter the student email: ");
			email = scanner.next();
			student.setEmail(email);

			System.out.println("Enter the student contact: ");
			contact = scanner.nextLong();
			student.setContact(contact);

			System.out.println("Enter the student city: ");
			city = scanner.next();
			student.setCity(city);

			manager.persist(student);
			
			transaction.commit();

		}

		closeConnection();

	}
	
	public static void update() {
		
	}
	
	public static void delete() {
		
openConnection();
		
		transaction.begin();
		
		System.out.println("Enter the student id: ");
		id = scanner.nextInt();
		StudentDTO student = manager.find(StudentDTO.class, id);
		manager.remove(student);
		
		transaction.commit();
		
		closeConnection();
		
	}
	
	public static void search() {
		
		openConnection();
		
		transaction.begin();
		
		System.out.println("Enter the student id: ");
		id = scanner.nextInt();
		StudentDTO student = manager.find(StudentDTO.class, id);
		System.out.println(student);
		
		transaction.commit();
		
		closeConnection();
		
	}
	
	public static void main(String[] args) {
		
		delete();
		
	}

}

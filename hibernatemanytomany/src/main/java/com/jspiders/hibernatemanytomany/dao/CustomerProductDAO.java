package com.jspiders.hibernatemanytomany.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernatemanytomany.dto.CustomerDTO;
import com.jspiders.hibernatemanytomany.dto.ProductDTO;

public class CustomerProductDAO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;

	private static void openConnection() {
		factory = Persistence.
				createEntityManagerFactory("ManyToMany");
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
		
		CustomerDTO customer1 = new CustomerDTO();
		customer1.setId(1);
		customer1.setName("Dhiraj");
		customer1.setEmail("dhiraj@gmail.com");
		customer1.setContact(9876543210L);
		
		CustomerDTO customer2 = new CustomerDTO();
		customer2.setId(2);
		customer2.setName("Pushpa");
		customer2.setEmail("pushpa@gmail.com");
		customer2.setContact(9876521210L);
		
		CustomerDTO customer3 = new CustomerDTO();
		customer3.setId(3);
		customer3.setName("Rocky");
		customer3.setEmail("rocky@gmail.com");
		customer3.setContact(9898712310L);
		
		ProductDTO product1 = new ProductDTO();
		product1.setId(1);
		product1.setName("Shirt");
		product1.setPrice(1500);
		product1.setCategory("Clothing");
		
		ProductDTO product2 = new ProductDTO();
		product2.setId(2);
		product2.setName("Shoes");
		product2.setPrice(2500);
		product2.setCategory("Footwear");
		
		ProductDTO product3 = new ProductDTO();
		product3.setId(3);
		product3.setName("Watch");
		product3.setPrice(2000);
		product3.setCategory("Accessories");
		
		List<ProductDTO> products = 
				Arrays.asList(product1, product2, product3);
		
		customer1.setProducts(products);
		customer2.setProducts(products);
		customer3.setProducts(products);
		
		manager.persist(customer1);
		manager.persist(customer2);
		manager.persist(customer3);

		List<CustomerDTO> customers = 
				Arrays.asList(customer1, customer2, customer3);
		
		product1.setCustomers(customers);
		product2.setCustomers(customers);
		product3.setCustomers(customers);
		
		manager.persist(product1);
		manager.persist(product2);
		manager.persist(product3);
		
		transaction.commit();
		closeConnection();
		
	}

}

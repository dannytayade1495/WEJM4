package com.jspiders.multithreadingwaitandnotify.main;

import com.jspiders.multithreadingwaitandnotify.resources.Shop;
import com.jspiders.multithreadingwaitandnotify.threads.Customer;
import com.jspiders.multithreadingwaitandnotify.threads.Supplier;

public class ShopMain {
	
	public static void main(String[] args) {
		Shop shop = new Shop(100);
		Customer customer1 = new Customer(shop, 50);
		Customer customer2 = new Customer(shop, 70);
		Supplier supplier = new Supplier(shop, 100);
		
		customer1.start();
		customer2.start();
		supplier.start();
	}

}
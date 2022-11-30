package com.jspiders.factorypattern.main;

import java.util.Scanner;

import com.jspiders.factorypattern.items.Burger;
import com.jspiders.factorypattern.items.Coffee;
import com.jspiders.factorypattern.items.Fries;
import com.jspiders.factorypattern.items.Momos;
import com.jspiders.factorypattern.items.Pasta;
import com.jspiders.factorypattern.items.Pizza;
import com.jspiders.factorypattern.order.Order;

public class Cafe {

	private static Order order;
	private static boolean loop = true;
	private static int choice;
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		while (loop) {
			try {
				factory().orderItem();
			} catch (NullPointerException e) {
				System.out.println("No order recieved.");
			}
		}

	}

	private static Order factory() {

		System.out.println("=====MENU=====\n" 
						+ "1. Pizza\n" 
						+ "2. Burger\n" 
						+ "3. Fries\n" 
						+ "4. Coffee\n"
						+ "5. Momos\n"
						+ "6. Pasta\n" 
						+ "7. Exit");

		choice = scanner.nextInt();

		switch (choice) {
		case 1:
			order = new Pizza();
			break;

		case 2:
			order = new Burger();
			break;

		case 3:
			order = new Fries();
			break;

		case 4:
			order = new Coffee();
			break;

		case 5:
			order = new Momos();
			break;

		case 6:
			order = new Pasta();
			break;

		case 7:
			System.out.println("Thank you. Visit Again.");
			loop = false;
			break;
		default:
			System.out.println("Invalid choice.");
			order = null;
			break;
		}

		return order;
	}

}

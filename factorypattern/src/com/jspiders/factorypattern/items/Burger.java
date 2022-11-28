package com.jspiders.factorypattern.items;

import com.jspiders.factorypattern.order.Order;

public class Burger implements Order {
	
	@Override
	public void orderItem() {
		System.out.println("Ordering Burger.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Burger ready.");
	}

}

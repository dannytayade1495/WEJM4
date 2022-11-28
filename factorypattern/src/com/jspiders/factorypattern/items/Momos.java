package com.jspiders.factorypattern.items;

import com.jspiders.factorypattern.order.Order;

public class Momos implements Order {
	
	@Override
	public void orderItem() {
		System.out.println("Ordering Momos.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Momos ready.");
	}

}

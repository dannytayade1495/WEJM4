package com.jspiders.factorypattern.items;

import com.jspiders.factorypattern.order.Order;

public class Coffee implements Order {
	
	@Override
	public void orderItem() {
		System.out.println("Ordering Coffee.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Coffee ready.");
	}

}

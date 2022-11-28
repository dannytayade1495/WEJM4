package com.jspiders.multithreadingwaitandnotify.resources;

public class Shop {

	int noOfProducts;

	public Shop(int noOfProducts) {
		super();
		this.noOfProducts = noOfProducts;
	}

	public synchronized void restockProducts(int restockProducts) {
		noOfProducts += restockProducts;
		System.out.println(restockProducts 
				+ " successfully added to the stock");
		System.out.println("Now available products : " + noOfProducts);
		this.notify();
	}
	
	public synchronized void purchaseProducts(int purchaseProducts) {
		if (noOfProducts < purchaseProducts) {
			System.out.println(purchaseProducts 
					+ " products not available. Please wait");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		noOfProducts -= purchaseProducts;
		System.out.println(purchaseProducts + " successfully purchased");
		System.out.println("Now available products : " + noOfProducts);
	}

}
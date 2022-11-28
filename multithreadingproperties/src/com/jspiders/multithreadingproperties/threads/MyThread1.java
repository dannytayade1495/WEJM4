package com.jspiders.multithreadingproperties.threads;

public class MyThread1 extends Thread {

	@Override
	public void run() {
		System.out.println
		("The name of the thread is : " + this.getName());
		System.out.println
		("The priority of the thread is : " + this.getPriority());
	}

}

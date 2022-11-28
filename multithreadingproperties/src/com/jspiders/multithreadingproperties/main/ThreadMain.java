package com.jspiders.multithreadingproperties.main;

import com.jspiders.multithreadingproperties.threads.MyThread2;

public class ThreadMain {
	
	public static void main(String[] args) {
		
		MyThread2 myThread2 = new MyThread2();
		Thread thread = new Thread(myThread2);
		
		thread.setName("T2");
		thread.setPriority(9);
		
		thread.start();
		
	}

}

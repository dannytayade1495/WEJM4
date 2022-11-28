package com.jspiders.multithreading.main;

import com.jspiders.multithreading.threads.MyThread1;
import com.jspiders.multithreading.threads.MyThread2;
import com.jspiders.multithreading.threads.MyThread3;
import com.jspiders.multithreading.threads.MyThread4;

public class ThreadProperties {
	
	public static void main(String[] args) {
		
		MyThread1 myThread1 = new MyThread1();
		myThread1.setPriority(9);
		
		MyThread2 myThread2 = new MyThread2();
		Thread thread = new Thread(myThread2);
		thread.setPriority(7);
		
		MyThread3 myThread3 = new MyThread3();
		myThread3.setPriority(8);
		
		MyThread4 myThread4 = new MyThread4();
		myThread4.setPriority(10);
		
		myThread1.start();
		thread.start();
		myThread3.start();
		myThread4.start();
	}

}

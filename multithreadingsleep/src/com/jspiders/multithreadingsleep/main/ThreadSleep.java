package com.jspiders.multithreadingsleep.main;

public class ThreadSleep {

	public static void main(String[] args) {

		String str = "Welcome to WEJM4";
		char[] charArray = str.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			System.out.print(charArray[i]);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

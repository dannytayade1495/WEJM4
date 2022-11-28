package com.jspiders.singleton.main;

import com.jspiders.singleton.object.SingletonEager;

public class SingletonEagerMain {
	
	public static void main(String[] args) {
		
		SingletonEager.getObject();
		SingletonEager.getObject();
		SingletonEager.getObject();
		SingletonEager.getObject();
		
	}

}

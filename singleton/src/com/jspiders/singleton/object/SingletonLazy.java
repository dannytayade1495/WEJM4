package com.jspiders.singleton.object;

public class SingletonLazy {

	static SingletonLazy object; //null //@100
	static int count;  //0 //1

	private SingletonLazy() {
		count++;
	}

	public static SingletonLazy getObject() {
		if (object == null) {
			object = new SingletonLazy();
		}
		System.out.println("Object created " + count + " times");
		return object;
	}

}

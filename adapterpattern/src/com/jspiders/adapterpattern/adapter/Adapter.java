package com.jspiders.adapterpattern.adapter;

import com.jspiders.adapterpattern.interfaces.Mock;
import com.jspiders.adapterpattern.object.Wejm4;

public class Adapter extends Wejm4 implements Mock {
	
	private static Adapter adapter = new Adapter();
	
	public static void main(String[] args) {
		adapter.rating();
	}

	@Override
	public void rating() {
		
		adapter.setId(1);
		adapter.setName("Akshay");
		adapter.setTech_rating("1");
		adapter.setComm_rating("1");
		
		System.out.println(adapter.getName() 
				+ " has technical rating as : " 
				+ adapter.getTech_rating() 
				+ " and communication rating as : "
				+ adapter.getComm_rating());
		
	}

}

package com.jspiders.builderpattern.main;

import com.jspiders.builderpattern.builder.MobileBuilder;
import com.jspiders.builderpattern.object.Mobile;

public class MobileMain {
	
	public static void main(String[] args) {
		
		Mobile mobile = new MobileBuilder().brand("Samsung")
		.price(100000.00).model("S24").getMobile();
		
		System.out.println(mobile);
		
	}

}

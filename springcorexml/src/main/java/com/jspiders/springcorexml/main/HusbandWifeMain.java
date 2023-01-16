package com.jspiders.springcorexml.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcorexml.beans.HusbandBean;

public class HusbandWifeMain {
	
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("HusbandWifeConfig.xml");
		HusbandBean husband1 = (HusbandBean)context.getBean("husband1");
		System.out.println(husband1);
		((ClassPathXmlApplicationContext)context).close();
	}

}

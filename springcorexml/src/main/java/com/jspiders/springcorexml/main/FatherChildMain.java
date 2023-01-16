package com.jspiders.springcorexml.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcorexml.beans.FatherBean;

public class FatherChildMain {
	
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("FatherChildConfig.xml");
		FatherBean father1 = context.getBean(FatherBean.class);
		System.out.println(father1);
		((ClassPathXmlApplicationContext)context).close();
	}

}

package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resources.Account;
import com.jspiders.multithreading.threads.Husband;
import com.jspiders.multithreading.threads.Wife;

public class AccountMain {

	public static void main(String[] args) {

		Account account = new Account(10000);
		Husband husband = new Husband(account);
		Wife wife = new Wife(account);

		husband.start();
		wife.start();
	}

}
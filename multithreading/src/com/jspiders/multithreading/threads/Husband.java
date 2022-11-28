package com.jspiders.multithreading.threads;

import com.jspiders.multithreading.resources.Account;

public class Husband extends Thread{
	
	Account account;

	public Husband(Account account) {
		super();
		this.account = account;
	}
	
	@Override
	public void run() {
		account.deposit(5000);
		account.withdraw(7000);
	}

}

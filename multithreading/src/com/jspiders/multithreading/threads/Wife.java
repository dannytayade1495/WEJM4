package com.jspiders.multithreading.threads;

import com.jspiders.multithreading.resources.Account;

public class Wife extends Thread {

	Account account;

	public Wife(Account account) {
		super();
		this.account = account;
	}

	@Override
	public void run() {
		account.deposit(3000);
		account.withdraw(8000);
	}

}

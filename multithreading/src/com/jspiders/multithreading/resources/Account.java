package com.jspiders.multithreading.resources;

public class Account {

	int accountBalance;

	public Account(int accountBalance) {
		super();
		this.accountBalance = accountBalance;
	}

	public synchronized void deposit(int depositAmount) {
		System.out.println("Depositing " + depositAmount 
				+ " rupees in the account");
		accountBalance += depositAmount;
		System.out.println("Available balance : " + accountBalance);
	}

	public synchronized void withdraw(int withdrawAmount) {
		if (accountBalance >= withdrawAmount) {
			System.out.println("Withdrawing " + withdrawAmount 
					+ " from the account");
			accountBalance -= withdrawAmount;
			System.out.println("Available balance : " + accountBalance);
		} else {
			System.out.println("Insufficient balance");
		}
	}

}
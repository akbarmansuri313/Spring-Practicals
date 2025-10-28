package com.rays.ioc;

public class Payment {
	
	double balance = 0;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double makePayment(double amount) {
		
		balance -= amount;
		return balance;
		
	}
	
	public double deposite (double amount) {
		
		balance += amount;
		return balance;
	}

}

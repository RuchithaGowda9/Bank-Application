package com.crimsonlogic.bankapplication;

public class SavingsAccount extends BankAccount {
	static double default_rate = 0.3;
	static private double interest_rate = 0.2;

	public SavingsAccount() {

	}

	public SavingsAccount(double balance) {
		super(balance);

	}

	public SavingsAccount(double balance, double interest_rate) {
		super(balance);
		this.interest_rate = interest_rate;
	}

	public void applyInterest() {
		BankAccount ba = new BankAccount();
		User u = new User();
		int userid = u.getUserId();
		balance = balance + (balance * ba.getBalance(userid));
	}
}

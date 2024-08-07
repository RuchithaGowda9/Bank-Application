package com.crimsonlogic.bankapplication;

import java.text.DecimalFormat;

public class BankAccount implements Account {
	static DecimalFormat money = new DecimalFormat("$#,##0.00");
	static protected double balance;

	public BankAccount() {

	}

	public BankAccount(double balance) {
		super();
		this.balance = balance;
	}

	@Override
	public double getBalance(int userid) {
		return balance;
	}

	@Override
	public double deposit(double depositAmount) {
		balance = balance + depositAmount;
		System.out.println(balance);
		return balance;
	}

	@Override
	public double withdraw(double withdrawAmount) {
		balance = balance - withdrawAmount;
		System.out.println(balance);
		return balance;
	}
}

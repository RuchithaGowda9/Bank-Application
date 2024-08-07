package com.crimsonlogic.bankapplication;

public class CurrentAccount extends BankAccount {
	static double default_fee = 5.00;
	static double monthlyFee = 150;

	public CurrentAccount() {

	}

	public void applyMonthlyFee() {
		BankAccount ba = new BankAccount();
		User u = new User();
		int userid = u.getUserId();
		balance = balance - ba.getBalance(userid);
	}

}

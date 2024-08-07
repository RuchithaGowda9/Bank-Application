package com.crimsonlogic.bankapplication;

public class BankRunner {

	public void menu() {

	}

	public static void main(String[] args) {
		CurrentAccount ca = new CurrentAccount();
		ca.applyMonthlyFee();
		SavingsAccount sa = new SavingsAccount();
		sa.applyInterest();
		UserOperations uo = new UserOperations();
		uo.bankingMenu();

	}

}

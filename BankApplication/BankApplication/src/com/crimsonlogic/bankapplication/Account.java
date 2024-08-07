package com.crimsonlogic.bankapplication;

public interface Account {

	float minBalance = 6000f;

	double getBalance(int userid);

	double deposit(double depositAmount);

	double withdraw(double withdrawAmount);
}

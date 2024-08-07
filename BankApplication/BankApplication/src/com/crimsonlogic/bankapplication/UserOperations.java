package com.crimsonlogic.bankapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserOperations {
	int choice2;
	static int choice;
	static int uid = 2000000;
	List<User> users = new ArrayList<User>();
	User u;

	Scanner sc = new Scanner(System.in);

	public void readChoice() {
		System.out.println("Enter choice");
		System.out.println("1: Register for new users");
		System.out.println("2: Login for existing users");
		System.out.println("0: Exit");
		choice = sc.nextInt();
	}

	public void bankingMenu() {

		do {
			readChoice();
			switch (choice) {
			case 1:
				registerUser();
				break;
			case 2:
				login();
				break;
			case 0:
				break;
			default:
				System.out.println("Enter valid choice");
				break;
			}
		} while (choice != 0);
	}

	private void login() {
		System.out.println("Enter username");
		String username = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		try {
			for (User user : users) {

				if (username.equals(user.getUsername())) {
					if (password.equals(user.getPassword())) {
						loginchoice(user);
					} else {
						System.out.println("Incorrect password. Please try again");
					}
				} else {
					throw new UserNotFoundException("User not registered");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void loginMenu() {
		System.out.println("Enter choice");
		System.out.println("1: Deposit");
		System.out.println("2: Withdraw");
		System.out.println("3: Check balance");
		System.out.println("0: Exit");
		choice2 = sc.nextInt();
	}

	private void loginchoice(User user) {
		do {
			loginMenu();
			switch (choice2) {
			case 1:
				depositMoney();
				break;
			case 2:
				withdrawMoney();
				break;
			case 3:
				checkBalance();
				break;
			case 0:
				break;
			default:
				System.out.println("Enter valid choice");
				break;
			}
		} while (choice2 != 0);

	}

	private void checkBalance() {
		BankAccount ba = new BankAccount();
		int userid = u.getUserId();
		System.out.println(ba.getBalance(userid));

	}

	private void withdrawMoney() {
		BankAccount ba = new BankAccount();
		int userid = u.getUserId();
		System.out.println("Enter money to be withdrawed");
		double amount = sc.nextDouble();
		try {
			if (amount > ba.getBalance(userid)) {
				throw new LowBalanceException("Low balance. Withdraw failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ba.withdraw(amount);
	}

	private void depositMoney() {
		BankAccount ba = new BankAccount();
		System.out.println("Enter money to be deposited");
		double amount = sc.nextDouble();
		try {
			if (amount <= 0) {
				throw new InvalidAmountException("Enter valid amount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ba.deposit(amount);

	}

	private void registerUser() {
		u = new User();
		System.out.println("Enter Username");
		String uname = sc.next();
		u.setUsername(uname);
		System.out.println("Enter Password");
		String pw = sc.next();
		System.out.println(pw);
		u.setPassword(pw);
		u.setUserId(uid);
		uid++;

		users.add(u);

		// System.out.println("All users");
		// for (User user : users) {
		// System.out.println(user);
		// }
		System.out.println("Registered successfully");
		System.out.println("User Id: " + uid + "\nUsername : " + uname);

	}

}

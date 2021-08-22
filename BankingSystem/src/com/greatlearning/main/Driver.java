package com.greatlearning.main;

import com.greatlearning.models.*;
import com.greatlearning.services.*;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		BankingService bankingService = new BankingService();
		
		Customer customer1 = new Customer(123456,"abc",1000);
		
		Scanner sc = new Scanner(System.in);
		String pass;
		int accno;
		
		System.out.println("Welcome to the login page");
		System.out.println();
		System.out.println("Enter your Account number : ");
		accno = sc.nextInt();
		System.out.println("Enter the password : ");
		pass = sc.next();
		
		Customer loggedInCustomer = new Customer(accno,pass);
		
		if(validateCustomer(customer1,loggedInCustomer)) {
			int option = 0;
			loggedInCustomer = customer1;
			do {
				System.out.println();
				System.out.println("-------------------------");
				System.out.println("1. Deposit");
				System.out.println("2. Withdrawal");
				System.out.println("3. Transfer");
				System.out.println("0. Logout");
				System.out.println("-------------------------");
				System.out.println();
				
				option = sc.nextInt();
				
				switch(option) {
				case 0:
					bankingService.logOut();
					break;
				case 1:
					bankingService.deposit(loggedInCustomer);
					break;
				case 2:
					bankingService.withdraw(loggedInCustomer);
					break;
				case 3:
					bankingService.transfer(loggedInCustomer);
					break;
				}
				
			} while(option != 0);
		}
		else {
			System.out.println("Please enter valid credentials");
		}
		
		sc.close();
	}

	private static boolean validateCustomer(Customer customer, Customer loggedInCustomer) {
		System.out.println(customer.getBankAccountno() + "/" + loggedInCustomer.getBankAccountno());
		System.out.println(customer.getPassword() + "/" + loggedInCustomer.getPassword());
		
		boolean res = (customer.getBankAccountno() == loggedInCustomer.getBankAccountno()) && (customer.getPassword() == loggedInCustomer.getPassword());
		System.out.println(res);
		
		return res;
	}
}

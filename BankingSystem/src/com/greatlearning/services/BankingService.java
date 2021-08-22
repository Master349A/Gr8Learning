package com.greatlearning.services;

import com.greatlearning.models.*;
import java.util.Scanner;

public class BankingService {
	Scanner sc = new Scanner(System.in);
	int bankBalance = 1000;
	
	public void logOut() {
		System.out.println("Thank you for banking with us!!!");
	}
	
	public void deposit(Customer customer) {
		int amount;
		System.out.println("Enter amount to be deposited");
		amount = sc.nextInt();
		if (amount > 0) {
			System.out.println("Amount deposited successfully");
			customer.setBalance(customer.getBalance() + amount);
			System.out.println("Updated balance amount : "+customer.getBalance());
		}
		else {
			System.out.println("Please enter valid amount!");
		}
	}
	
	public void withdraw(Customer customer) {
		int amount;
		System.out.println("Please enter amount to be withdrawn : ");
		amount = sc.nextInt();
		
		if (amount < customer.getBalance()) {
			System.out.println("Amount withdrawn successfully!");
			customer.setBalance(customer.getBalance() - amount);
			System.out.println("Updated balance : " + customer.getBalance());
		}
		else {
			System.out.println("Insufficient funds");
		}
	}
	
	public void transfer(Customer customer) {
		int amount;
		int otp,generatedotp;
		int destAccountNo = 0;
		
		System.out.println("Generating OTP...");
		OTPService otps = new OTPService();
		generatedotp = otps.generateOTP();
		
		System.out.println("Please enter OTP : ");
		otp = sc.nextInt();
		
		if (otp == generatedotp) {
			System.out.println("Enter amount to be transfered :");
			amount = sc.nextInt();
			if (amount < customer.getBalance()) {
				System.out.println("Amount successfully transfered to " + destAccountNo);
				customer.setBalance(customer.getBalance() - amount);
				System.out.println("Updated balance : " + customer.getBalance());
			}
			else {
				System.out.println("Insufficient funds!");
			}
		}
		else {
			System.out.println("Invalid OTP!!!");
		}
	}
}

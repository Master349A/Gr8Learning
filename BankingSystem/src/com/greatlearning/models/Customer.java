package com.greatlearning.models;

public class Customer {
	private int bankAccountno;
	private String password;
	private int balance;
	
	public Customer(int bankAccountno, String password, int balance) {
		this.password = password;
		this.bankAccountno = bankAccountno;
		this.balance = balance;
	}
	
	public Customer(int bankAccountno, String password) {
		this.password = password;
		this.bankAccountno = bankAccountno;
		this.balance = 1000;
	}
	
	public int getBankAccountno() {
		return bankAccountno;
	}
	
	public void setBankAccountno(int bankAccountno) {
		this.bankAccountno = bankAccountno;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
}

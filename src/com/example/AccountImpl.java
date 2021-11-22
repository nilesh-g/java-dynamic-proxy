package com.example;

public class AccountImpl implements IAccount {
	private int id;
	private double balance;
	
	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public double getBalance() {
		return this.balance;
	}

	@Override
	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public void deposit(double amount) {
		this.balance += amount;
	}

	@Override
	public void withdraw(double amount) {
		if(this.balance < amount)
			throw new RuntimeException("Insifficient balance.");
		this.balance -= amount;
	}

}


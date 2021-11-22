package com.example;

public interface IAccount {
	int getId();
	void setId(int id);
	double getBalance();
	void setBalance(double balance);
	void deposit(double amount);
	void withdraw(double amount);
}

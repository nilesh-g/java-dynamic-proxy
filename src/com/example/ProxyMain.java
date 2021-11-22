package com.example;

import java.lang.reflect.Proxy;

public class ProxyMain {
	public static void main(String[] args) {
		AccountImpl acc = new AccountImpl();
		acc.setId(101);
		acc.setBalance(10000);
		
		IAccount proxy = AccountProxyHandler.getAccountProxy(acc);
		System.out.println(proxy.getClass().getName());
		
		proxy.deposit(2000);
		proxy.withdraw(-3000);
	}
}

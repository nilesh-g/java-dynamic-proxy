package com.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AccountProxyHandler implements InvocationHandler {
	private IAccount target;
	public AccountProxyHandler(IAccount target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// pre-processing
		if(method.getName().equals("deposit") || method.getName().equals("withdraw")) {
			double amount = (Double) args[0];
			if(amount <= 0.0)
				throw new RuntimeException("Invalid amount.");
		}
		// call business logic
		Object result = method.invoke(target, args);
		// post-processing
		System.out.println(method.getName() + " on account " + target.getId());
		return result;
	}

	public static IAccount getAccountProxy(IAccount acc) {
		AccountProxyHandler accHandler = new AccountProxyHandler(acc);
		
		IAccount proxy = (IAccount) Proxy.newProxyInstance(AccountImpl.class.getClassLoader(), 
						new Class[] { IAccount.class }, 
						accHandler);
		return proxy;
	}
}


package com.capgemini.stockExchange.Exceptions;
public class MyException extends Exception {

	private static final long serialVersionUID = 1L;

	public MyException(String msg) {
		super("MyException: \n"+msg);
		System.out.println(getMessage());
	}
	
	
	
	
	
}
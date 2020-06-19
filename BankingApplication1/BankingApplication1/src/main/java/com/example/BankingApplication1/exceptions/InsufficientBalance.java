package com.example.BankingApplication1.exceptions;

public class InsufficientBalance extends Exception {
	public InsufficientBalance(String string) {
		super("entered amount is greater than the available balance");
	}

}

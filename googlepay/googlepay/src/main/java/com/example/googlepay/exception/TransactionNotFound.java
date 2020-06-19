package com.example.googlepay.exception;

public class TransactionNotFound extends RuntimeException {
	private String message;

	public String getMessage() {

		return message;

	}

	public void setMessage(String message) {

		this.message = message;

	}

}

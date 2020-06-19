package com.product.SpringDataJpaUsingCustomQueries.Exception;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException() {
		super("user not found");
	}

}

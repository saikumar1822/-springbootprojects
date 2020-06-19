package com.product.SpringDataJpaUsingCustomQueries.Exception;

public class UserNotLoggedIn extends RuntimeException {
	
 public UserNotLoggedIn() {
	 super("user not logged in");
 }
}

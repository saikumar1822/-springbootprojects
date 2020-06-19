package com.product.SpringDataJpaUsingCustomQueries.Exception;

public class NoDataFoundException extends RuntimeException {
	
	public NoDataFoundException() {
		super("no data found");
	}
}

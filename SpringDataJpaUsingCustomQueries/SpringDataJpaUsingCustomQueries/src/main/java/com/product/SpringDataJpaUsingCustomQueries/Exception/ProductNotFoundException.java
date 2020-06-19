package com.product.SpringDataJpaUsingCustomQueries.Exception;

public class ProductNotFoundException extends RuntimeException {
	
	public ProductNotFoundException(int pId) {
		 super(String.format("product with pId %d not found", pId));
	}

}

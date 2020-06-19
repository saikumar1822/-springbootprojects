package com.learn.Ecommerce1.dto;

import java.util.List;

import com.learn.Ecommerce1.model.Product;
import com.learn.Ecommerce1.model.ProductRating;
import com.learn.Ecommerce1.model.Store;

public class StoreReviewResponseDto {
	private Product product;
	
	private List<Store> store;
	
	private List<ProductRating> productRating;
	

	public List<ProductRating> getProductRating() {
		return productRating;
	}

	public void setProductRating(List<ProductRating> productRating) {
		this.productRating = productRating;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Store> getStore() {
		return store;
	}

	public void setStore(List<Store> store) {
		this.store = store;
	}
	
	

}

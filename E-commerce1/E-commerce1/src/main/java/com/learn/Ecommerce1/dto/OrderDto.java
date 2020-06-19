package com.learn.Ecommerce1.dto;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learn.Ecommerce1.model.Product;
import com.learn.Ecommerce1.model.User;

public class OrderDto {
	private int id;
	private long accountNumber;
	private long ecommerceAccountNumber;
	 @JsonIgnore
		@OneToMany( cascade = CascadeType.MERGE)
		private List <Product> productList;
		
	    @ManyToOne(cascade = CascadeType.MERGE)
		private User user;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public long getEcommerceAccountNumber() {
		return ecommerceAccountNumber;
	}
	public void setEcommerceAccountNumber(long ecommerceAccountNumber) {
		this.ecommerceAccountNumber = ecommerceAccountNumber;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}

package com.learn.ecommerce.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Store_Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long quantity;
	
	@ManyToOne()
	@JoinColumn(name = "storeId")
	private Store store;

	@ManyToOne()
	@JoinColumn(name = "productId")
	private Product product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Store_Product [id=" + id + ", quantity=" + quantity + ", store=" + store + ", product=" + product + "]";
	}
	
	

	/*
	 * private Long productId;
	 * 
	 * private Long storeId;
	 * 
	 * 
	 * 
	 * 
	 * public Store_Product() {
	 * 
	 * }
	 * 
	 * public Long getId() { return id; }
	 * 
	 * public void setId(Long id) { this.id = id; }
	 * 
	 * public Long getProductId() { return productId; }
	 * 
	 * public void setProductId(Long productId) { this.productId = productId; }
	 * 
	 * public Long getStoreId() { return storeId; }
	 * 
	 * public void setStoreId(Long storeId) { this.storeId = storeId; }
	 * 
	 * public Long getQuantity() { return quantity; }
	 * 
	 * public void setQuantity(Long quantity) { this.quantity = quantity; }
	 * 
	 * @Override public String toString() { return "Store_Product [id=" + id +
	 * ", productId=" + productId + ", storeId=" + storeId + ", quantity=" +
	 * quantity + "]"; }
	 */

}

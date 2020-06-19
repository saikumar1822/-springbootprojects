package com.learn.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product_rating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//one to one 
//	privt order order
	@ManyToOne()
	@JoinColumn(name = "userId")
	private User user;

	@ManyToOne()
	@JoinColumn(name = "productId")
	private Product product;

	private double rating;

	private String feedback;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Product_rating [id=" + id + ", user=" + user + ", product=" + product + ", rating=" + rating
				+ ", feedback=" + feedback + "]";
	}

}

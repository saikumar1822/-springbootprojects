package com.learn.Ecommerce1.dto;


public class ProductReviewDto {
	private long userId;

	private long productId;

	private Double rating;

	private String feedBack;

	public long getUserId() {

		return userId;

	}

	public void setUserId(long userId) {

		this.userId = userId;

	}

	public long getProductId() {

		return productId;

	}

	public void setProductId(long productId) {

		this.productId = productId;

	}

	public Double getRating() {

		return rating;

	}

	public void setRating(Double rating) {

		this.rating = rating;

	}

	public String getFeedBack() {

		return feedBack;

	}

	public void setFeedBack(String feedBack) {

		this.feedBack = feedBack;

	}

}

package com.learn.Ecommerce1.dto;

public class StoreReviewDto {
	private long userId;

	private long storeId;

	private Double rating;

	private String feedBack;

	public long getUserId() {

		return userId;

	}

	public void setUserId(long userId) {

		this.userId = userId;

	}

	public long getStoreId() {

		return storeId;

	}

	public void setStoreId(long storeId) {

		this.storeId = storeId;

	}

	public double getRating() {

		return rating;

	}

	public void setRating(double rating) {

		this.rating = rating;

	}

	public String getFeedBack() {

		return feedBack;

	}

	public void setFeedBack(String feedBack) {

		this.feedBack = feedBack;

	}

}

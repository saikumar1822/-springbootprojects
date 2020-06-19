package com.learn.Ecommerce1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.Ecommerce1.dto.ProductReviewDto;
import com.learn.Ecommerce1.dto.ProductReviewResponse;
import com.learn.Ecommerce1.exception.OrderDetailsNotFoundException;
import com.learn.Ecommerce1.exception.ProductNameNotFoundException;
import com.learn.Ecommerce1.exception.ProductNotFound;
import com.learn.Ecommerce1.exception.UserIdNotFound;
import com.learn.Ecommerce1.service.ProductReviewService;
@RestController
public class ProductRatingController {
	@Autowired
	ProductReviewService productReviewService;
	@PostMapping("/productRating")
	public ProductReviewResponse ReviewStore(@RequestBody ProductReviewDto productReviewDto)
			throws ProductNameNotFoundException, UserIdNotFound, ProductNotFound, OrderDetailsNotFoundException {
		ProductReviewResponse productReviewResponse;

		productReviewResponse=productReviewService.save(productReviewDto);

		return productReviewResponse;
	}

}




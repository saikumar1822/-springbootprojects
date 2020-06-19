package com.learn.Ecommerce1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.Ecommerce1.dto.StoreReviewResponseDto;
import com.learn.Ecommerce1.exception.ProductNameNotFoundException;
import com.learn.Ecommerce1.exception.ProductNotFound;
import com.learn.Ecommerce1.service.ProductService;

@RestController
public class ProductController {
	@Autowired

	ProductService productService;

	
	
	
	@GetMapping("/product")
	public ResponseEntity<StoreReviewResponseDto> getProduct(@RequestParam String productName) throws ProductNameNotFoundException, ProductNotFound {

		StoreReviewResponseDto product=productService.getProduct(productName);

		return new ResponseEntity<>(product, HttpStatus.OK);

	}
	



}

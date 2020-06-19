package com.learn.Ecommerce1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.Ecommerce1.dto.ResponseDto;
import com.learn.Ecommerce1.dto.StoreReviewDto;
import com.learn.Ecommerce1.exception.OrderDetailsNotFoundException;
import com.learn.Ecommerce1.exception.ProductNameNotFoundException;
import com.learn.Ecommerce1.exception.StoretNotFoundException;
import com.learn.Ecommerce1.exception.UserIdNotFound;
import com.learn.Ecommerce1.service.StoreReviewService;

@RestController
public class StoreReviewController {
	@Autowired
	StoreReviewService storeReviewService;
	@PostMapping("/review")
	public ResponseDto ReviewStore(@RequestBody StoreReviewDto StoreReviewDto)
			throws ProductNameNotFoundException, UserIdNotFound, OrderDetailsNotFoundException, StoretNotFoundException {
		ResponseDto responseDto;
		 responseDto=storeReviewService.save(StoreReviewDto);

		return responseDto;

	}

}




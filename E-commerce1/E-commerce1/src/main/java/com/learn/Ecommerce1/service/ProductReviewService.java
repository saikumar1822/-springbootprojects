package com.learn.Ecommerce1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.Ecommerce1.dto.ProductReviewDto;
import com.learn.Ecommerce1.dto.ProductReviewResponse;
import com.learn.Ecommerce1.exception.OrderDetailsNotFoundException;
import com.learn.Ecommerce1.exception.ProductNotFound;
import com.learn.Ecommerce1.exception.UserIdNotFound;
import com.learn.Ecommerce1.model.Product;
import com.learn.Ecommerce1.model.ProductRating;
import com.learn.Ecommerce1.model.User;
import com.learn.Ecommerce1.model.UserOrder;
import com.learn.Ecommerce1.repository.ProductRepository;
import com.learn.Ecommerce1.repository.ProductReviewRepository;
import com.learn.Ecommerce1.repository.UserOrderRepository;
import com.learn.Ecommerce1.repository.UserRepository;

@Service
public class ProductReviewService {
@Autowired
ProductReviewRepository productReviewRepository ;

@Autowired
ProductRepository productRepository;

@Autowired
UserRepository userRepository;


@Autowired
UserOrderRepository userOrderRepository;

	public ProductReviewResponse save(ProductReviewDto productReviewDto) throws UserIdNotFound, ProductNotFound, OrderDetailsNotFoundException {

		 User user = new User();
		 ProductRating productRating=new ProductRating();
		 
		
	   user=userRepository.findById(productReviewDto.getUserId()).orElseThrow(()->new UserIdNotFound("user with given id not found"));
		
	   Product product=productRepository.findById(productReviewDto.getProductId()).orElseThrow(()->new ProductNotFound("product not found"));
	   UserOrder order=userOrderRepository.findOrderByUserAndProduct(user,product);
		if(order != null) {
		
	   productRating.setProduct(product);
		productRating.setUser(user);
		productRating.setRating(productReviewDto.getRating());
		productRating.setFeedback(productReviewDto.getFeedBack());
		 productReviewRepository.save(productRating);
		 
		List<ProductRating> p= productReviewRepository.findByProduct(product);
		
		 double count= p.stream().count();
		  List<Double> d = p.stream().map(x -> x.getRating()).collect(Collectors.toList());
		  double sum = d.stream().mapToDouble(Double::doubleValue).sum();
		  product.setRating(sum/count);

		  productRepository.save(product);
		  
		  ProductReviewResponse productReviewResponse = new ProductReviewResponse();
		  productReviewResponse.setMessage("product review successfully given");
		  return productReviewResponse;

		 }
		else {
			throw new OrderDetailsNotFoundException("order details not found");
		}

		 }


	
	}



package com.learn.Ecommerce1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.Ecommerce1.dto.ResponseDto;
import com.learn.Ecommerce1.dto.StoreReviewDto;
import com.learn.Ecommerce1.exception.OrderDetailsNotFoundException;
import com.learn.Ecommerce1.exception.StoretNotFoundException;
import com.learn.Ecommerce1.exception.UserIdNotFound;
import com.learn.Ecommerce1.model.Store;
import com.learn.Ecommerce1.model.StoreReview;
import com.learn.Ecommerce1.model.User;
import com.learn.Ecommerce1.model.UserOrder;
import com.learn.Ecommerce1.repository.StoreRepository;
import com.learn.Ecommerce1.repository.StoreReviewRepository;
import com.learn.Ecommerce1.repository.UserOrderRepository;
import com.learn.Ecommerce1.repository.UserRepository;
@Service
public class StoreReviewService {
	@Autowired
	StoreReviewRepository storeReviewRepository;
	
	@Autowired
	StoreRepository storeRepository;
	
	@Autowired
	UserRepository userRepository;

	
	@Autowired
	 UserOrderRepository userOrderRepository;

	
	
	public ResponseDto save(StoreReviewDto storeReviewDto) throws UserIdNotFound, OrderDetailsNotFoundException, StoretNotFoundException {
		User user=userRepository.findById(storeReviewDto.getUserId()).orElseThrow(()->new UserIdNotFound("user with given id not found"));
		Store store=storeRepository.findById(storeReviewDto.getStoreId()).orElseThrow(()->new StoretNotFoundException("store not found"));
		UserOrder order=userOrderRepository.findOrderByUserAndStore(user,store);
		if(order != null) {
		StoreReview storeReview=new StoreReview();
		storeReview.setStore(store);
		storeReview.setFeedback(storeReviewDto.getFeedBack());
		storeReview.setRating(storeReviewDto.getRating());
		storeReview.setUser(user);
		storeReviewRepository.save(storeReview);
		List<StoreReview> r=storeReviewRepository.findByStore(store);
		 double count= r.stream().count();
		  List<Double> d = r.stream().map(x -> x.getRating()).collect(Collectors.toList());
		  double sum = d.stream().mapToDouble(Double::doubleValue).sum();
		  store.setRating(sum/count);
		  storeRepository.save(store);
		  ResponseDto response = new ResponseDto();
		  response.setMessage("store review successfully given");
		  return response;

		}
		else {
			throw new OrderDetailsNotFoundException("order details not found");
		}
	}

}

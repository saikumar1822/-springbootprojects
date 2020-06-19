package com.learn.Ecommerce1.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.Ecommerce1.dto.StoreReviewResponseDto;
import com.learn.Ecommerce1.exception.ProductNameNotFoundException;
import com.learn.Ecommerce1.exception.ProductNotFound;
import com.learn.Ecommerce1.model.Product;
import com.learn.Ecommerce1.model.ProductRating;
import com.learn.Ecommerce1.model.Store;
import com.learn.Ecommerce1.model.StoreProduct;
import com.learn.Ecommerce1.repository.ProductRepository;
import com.learn.Ecommerce1.repository.ProductReviewRepository;
import com.learn.Ecommerce1.repository.StoreProductRepository;
import com.learn.Ecommerce1.repository.StoreReviewRepository;

@Service
public class ProductService {
	@Autowired

	ProductRepository productRepository;
	
	@Autowired
	ProductReviewRepository productReviewRepository;
	
	@Autowired
	StoreReviewRepository storeReviewRepository;
	
	@Autowired
	StoreProductRepository storeProductRepository;

	public StoreReviewResponseDto getProduct(String productName) throws ProductNameNotFoundException, ProductNotFound {
		
		Product product=productRepository.findByName(productName);
		if(product!=null) {
		List<StoreProduct> pq=storeProductRepository.findByProduct(product);
		List<Store> r=pq.stream().map(m->m.getStore()).collect(Collectors.toList());
		List<Store> sorted=r.stream().sorted((i1,i2)->-i1.getRating().compareTo(i2.getRating())).
				  collect(Collectors.toList());
		StoreReviewResponseDto v=new StoreReviewResponseDto();
		v.setStore(sorted);
		v.setProduct(product);
		List<ProductRating> productRating =productReviewRepository.findByProduct(product);
		
		List<Product> r1=productRating.stream().map(m->m.getProduct()).collect(Collectors.toList());
		List<ProductRating> Productsorted=productRating.stream().sorted((i1,i2)->-i1.getRating().compareTo(i2.getRating())).
				  collect(Collectors.toList());
		v.setProductRating(Productsorted);
		return v;
		}else {
			throw new ProductNotFound("product not found");
		}
		
	
}
}

package com.learn.Ecommerce1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.Ecommerce1.model.Product;
import com.learn.Ecommerce1.model.Store;
import com.learn.Ecommerce1.model.User;
import com.learn.Ecommerce1.model.UserOrder;

public interface UserOrderRepository extends JpaRepository<UserOrder, Long>{

	UserOrder findOrderByUserAndStore(User user, Store store);

	UserOrder findOrderByUserAndProduct(User user, Product product);

}

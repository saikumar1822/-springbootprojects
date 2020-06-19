package com.example.hungerbox.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hungerbox.model.OrderItemList;

public interface OrderItemListRepository extends JpaRepository<OrderItemList,Long> {
	

}

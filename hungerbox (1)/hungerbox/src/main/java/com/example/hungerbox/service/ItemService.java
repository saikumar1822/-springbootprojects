package com.example.hungerbox.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hungerbox.exceptions.ItemNotFoundException;
import com.example.hungerbox.model.Item;
import com.example.hungerbox.repository.ItemRepository;

/**
 * 
 * @author sowjanya
 * this is class for item service
 *
 */

@Service
public class ItemService {
	
	Logger logger = LoggerFactory.getLogger(ItemService.class);
	
	@Autowired
	ItemRepository itemRepository;
	
	public List<Item> viewItemByName(String name) throws ItemNotFoundException {
		List<Item> items = itemRepository.findItemByNameLike("%" + name + "%");
			 if(items.isEmpty()) {
				 throw new ItemNotFoundException("item not found with the given name");
			 } 
			 return items;
		}



}

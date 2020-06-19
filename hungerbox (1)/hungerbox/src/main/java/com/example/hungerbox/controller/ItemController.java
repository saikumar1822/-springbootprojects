package com.example.hungerbox.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hungerbox.exceptions.ItemNotFoundException;
import com.example.hungerbox.model.Item;
import com.example.hungerbox.service.ItemService;
/**
 * 
 * @author Sowjanya
 * version:1.0
 * this is class for Item controller
 *
 */
@RestController
@RequestMapping("/items")
public class ItemController {
	Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	@Autowired
	ItemService itemService;
	
	/**
	 * 
	 * @param name
	 * @return
	 * @throws ItemNotFoundException
	 */
	@GetMapping("")
	public ResponseEntity<List<Item>> getItemByName(@RequestParam String name) throws ItemNotFoundException {

		 List<Item> item =  itemService.viewItemByName(name);
		return new ResponseEntity<>(item, HttpStatus.OK);
	}


}

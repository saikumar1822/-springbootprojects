package com.example.hungerbox.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.example.hungerbox.exceptions.ItemNotFoundException;
import com.example.hungerbox.model.Item;
import com.example.hungerbox.service.ItemService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ItemControllerTest {
	
	 @InjectMocks
	 ItemController itemController;
	 
	 @Mock
	 ItemService itemService;
	 
	
	 @Test
	    public void TestGetItemByNameForPositive() throws ItemNotFoundException {
	    	 List<Item> items = new ArrayList<>();
	    	 Item item=new Item();
	    	 item.setItemId(2l);
	    	 item.setName("noodles");
	    	 item.setItemDescription("spicy");
	    	 item.setUnitPrice(200.00);
	    	 item.setItemType("chineese");
		        items.add(item);
	         Mockito.when(itemService.viewItemByName(Mockito.anyString())).thenReturn(items);        
			ResponseEntity<List<Item>> result=itemController.getItemByName("noodles");
	    }
	 
	 @Test
	    public void TestGetItemByNameForNegative() throws ItemNotFoundException {
	    	 List<Item> items = new ArrayList<>();
	    	 Item item=new Item();
	    	 item.setItemId(-2l);
	    	 item.setName("noodles");
	    	 item.setItemDescription("spicy");
	    	 item.setUnitPrice(200.00);
	    	 item.setItemType("chineese");
		        items.add(item);
	         Mockito.when(itemService.viewItemByName(Mockito.anyString())).thenReturn(items);        
			ResponseEntity<List<Item>> result=itemController.getItemByName("noodles");
	    }

}

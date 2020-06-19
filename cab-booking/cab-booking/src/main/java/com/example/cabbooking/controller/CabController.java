package com.example.cabbooking.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cabbooking.dto.CabDto;
import com.example.cabbooking.dto.CabServiceDto;
import com.example.cabbooking.dto.SearchDto;
import com.example.cabbooking.exceptions.NoCabsFoundException;
import com.example.cabbooking.service.CabService;

@RestController
public class CabController {
	@Autowired
	CabService cabService;
	
	@PostMapping("/cab12")
	public CabServiceDto getAvaliableCabs(@RequestBody SearchDto timestamp) throws NoCabsFoundException, ParseException {
		return cabService.getCabs(timestamp);
	}
	
	
	  @PostMapping("/cab1")
	  public void saveCab(@RequestBody CabDto cabDto) {
	  cabService.cabSave(cabDto);
	  }
	 

}

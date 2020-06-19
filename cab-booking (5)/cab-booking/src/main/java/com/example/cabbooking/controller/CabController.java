package com.example.cabbooking.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cabbooking.dto.CabDto;
import com.example.cabbooking.dto.CabResponseDto;
import com.example.cabbooking.service.CabService;

@RestController
public class CabController {
	@Autowired
	CabService cabService;

	@PostMapping("")
	public String addCab(@RequestBody CabDto cabDto) {
		cabService.addCab(cabDto);
		return "Success";
	}

	@GetMapping("/search")
	public List<CabResponseDto> getCabDetails(@RequestParam(name = "localDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) {
		return cabService.getCabDetails(date);
	}
	

}

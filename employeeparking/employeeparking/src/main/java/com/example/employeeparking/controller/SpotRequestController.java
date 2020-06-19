package com.example.employeeparking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeparking.dto.ResponseDto;
import com.example.employeeparking.exception.NoFreeSpotsFoundException;
import com.example.employeeparking.exception.RequestNotProcessedException;
import com.example.employeeparking.exception.SpotRequestNotFoundException;
import com.example.employeeparking.service.SpotRequestService;
/**
 * SpotRequestController class is for processing requests based on lottery system
 * 
 * @author sai kumar
 * version 1-1
 * @since 2020-06-15
 *
 */
@RestController
public class SpotRequestController {
	Logger logger = LoggerFactory.getLogger(SpotRequestController.class);
	 
	
	
	@Autowired
	SpotRequestService spotRequestService;
	
	/**
	 * 
	 * @return String as status message
	 * @throws RequestNotProcessedException
	 * @throws SpotRequestNotFoundException
	 * @throws NoFreeSpotsFoundException
	 */
	
	@GetMapping("/LotterySystem")
	public ResponseEntity<ResponseDto> requestProcessingByLotterySystem() throws RequestNotProcessedException, SpotRequestNotFoundException, NoFreeSpotsFoundException {
		ResponseDto message =spotRequestService.requestProcessing();
		logger.info("requestProcessingByLotterySystem in Spot request controller");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}

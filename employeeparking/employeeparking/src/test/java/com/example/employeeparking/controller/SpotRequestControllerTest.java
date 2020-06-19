package com.example.employeeparking.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.employeeparking.dto.ResponseDto;
import com.example.employeeparking.service.SpotRequestService;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
	public class SpotRequestControllerTest {

	    @InjectMocks
	    SpotRequestController spotRequestController;
	    @Mock
	    SpotRequestService spotRequestService;
	    
	    ResponseDto responseDto = new ResponseDto();
	    
	    @Test
	    public void testCreateUserForPositive() throws Exception {
	       
	    	responseDto.setMessage("sucessful");
	    	responseDto.getMessage();
	        Mockito.when(spotRequestService.requestProcessing()).thenReturn(responseDto);
	        ResponseEntity<ResponseDto> responseDto1 = spotRequestController.requestProcessingByLotterySystem();
	    }
	    @Test(expected = NullPointerException.class)
	    public void testCreateUserForExce() throws Exception {
	    	 Mockito.when(spotRequestService.requestProcessing()).thenThrow(NullPointerException.class);
		    ResponseEntity<ResponseDto> responseDto1 = spotRequestController.requestProcessingByLotterySystem();
		    
	    }	    
	    
	}

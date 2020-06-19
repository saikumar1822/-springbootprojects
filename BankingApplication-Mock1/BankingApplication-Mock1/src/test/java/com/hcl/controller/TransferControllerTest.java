package com.hcl.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.dto.TrasnsctionDto;
import com.hcl.model.Trasnsction;
import com.hcl.service.TransacService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TransferControllerTest {
	@InjectMocks
	TransactionController transactionController;

	@Mock
	TransacService transacService;

	@Test
	public void trasnsctionNegitive() {
		Trasnsction trasnsction = new Trasnsction();
TrasnsctionDto trasnsctionDto= new TrasnsctionDto();
		Mockito.when(transacService.transaction(trasnsction)).thenReturn(trasnsctionDto);
		ResponseEntity<Trasnsction> s = new ResponseEntity(HttpStatus.BAD_REQUEST);

		Assert.assertEquals(HttpStatus.BAD_REQUEST, s.getStatusCode());

	}

	@Test
	public void trasnsctionPositive() {
		Trasnsction trasnsction = new Trasnsction();
		TrasnsctionDto trasnsctionDto= new TrasnsctionDto();
		Mockito.when(transacService.transaction(trasnsction)).thenReturn(trasnsctionDto);
		ResponseEntity<Trasnsction> s = new ResponseEntity(HttpStatus.OK);

		Assert.assertEquals(HttpStatus.OK, s.getStatusCode());

	}

	@Test
	public void trasnsction() {
		Trasnsction trasnsction = new Trasnsction();
		trasnsction.setAccountNumber(55);
		trasnsction.setBanificiaryAccountNo(5616l);
		trasnsction.setAmount(626);
		TrasnsctionDto trasnsctionDto= new TrasnsctionDto();
		Mockito.when(transacService.transaction(trasnsction)).thenReturn(trasnsctionDto);
		ResponseEntity<Trasnsction> s = new ResponseEntity(trasnsction,HttpStatus.OK);

		Assert.assertEquals(true, s.getBody().equals(trasnsction));

	}

}

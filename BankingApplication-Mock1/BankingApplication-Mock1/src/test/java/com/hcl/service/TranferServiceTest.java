package com.hcl.service;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.Exception.BanificiaryNotFoundException;
import com.hcl.model.Banificiary;
import com.hcl.model.Trasnsction;
import com.hcl.repository.BenificiaryRepositary;
import com.hcl.repository.TransactionRepositary;


@RunWith(MockitoJUnitRunner.Silent.class)
public class TranferServiceTest {
	@InjectMocks
	TransactionServiceImpl transactionServiceImpl;
	@Mock
	BenificiaryRepositary benificiaryRepositary;
	@Mock
	TransactionRepositary transactionRepositary;

	@Test(expected = BanificiaryNotFoundException.class)
	public void testTransactionException() {
		Trasnsction trasnsction = new Trasnsction();
		Mockito.when(benificiaryRepositary.findBanificiaryByBanificiaryAccountNo(trasnsction.getBanificiaryAccountNo()))
				.thenThrow(BanificiaryNotFoundException.class);
		Optional<Banificiary> banificiary = benificiaryRepositary
				.findBanificiaryByBanificiaryAccountNo(trasnsction.getBanificiaryAccountNo());

	}

	
	
	

}


package com.example.googlepay.exception;

public class BeneficiaryAccountNotFound extends RuntimeException {
	public BeneficiaryAccountNotFound(){
		super("Beneficiary AccountNumber is incorrect");
		
	}

}

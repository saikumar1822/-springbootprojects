package com.example.BankingApplication1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.BankingApplication1.exceptions.BeneficiaryAccountNotFound;
import com.example.BankingApplication1.model.BeneficiaryAccount;
import com.example.BankingApplication1.repository.BeneficiaryAccountRepository;

@Service
public class BeneficiaryAccountService {
	@Autowired
	BeneficiaryAccountRepository beneficiaryAccountRepository;

	public BeneficiaryAccount getBeneficiaryAccount(Long accountNumber) {
		try {
			return beneficiaryAccountRepository.findByAccountNumber(accountNumber);

		} catch (Exception e) {
			throw new BeneficiaryAccountNotFound();
		}

	}

	public void updateBeneficiaryAccountRepository(BeneficiaryAccount beneficiaryAccount) {

		beneficiaryAccountRepository.save(beneficiaryAccount);

	}
	
	public BeneficiaryAccount getBeneficiaryByPhoneNumber(String  phoneNumber) {
		try {
			return beneficiaryAccountRepository.findByPhoneNumber(phoneNumber);

		} catch (Exception e) {
			throw new BeneficiaryAccountNotFound();
		}

	}

}

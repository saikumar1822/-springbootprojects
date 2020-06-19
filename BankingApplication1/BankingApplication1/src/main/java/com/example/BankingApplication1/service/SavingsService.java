package com.example.BankingApplication1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankingApplication1.exceptions.BeneficiaryAccountNotFound;
import com.example.BankingApplication1.exceptions.CustomerNotFoundException;
import com.example.BankingApplication1.exceptions.InsufficientBalance;
import com.example.BankingApplication1.exceptions.PhoneNumberNotFoundException;
import com.example.BankingApplication1.exceptions.SavingsAccountIdNotFoundException;
import com.example.BankingApplication1.model.BeneficiaryAccount;
import com.example.BankingApplication1.model.Customer;
import com.example.BankingApplication1.model.SavingsAccount;
import com.example.BankingApplication1.model.Transaction;
import com.example.BankingApplication1.repository.SavingsRepository;

@Service
public class SavingsService {
	@Autowired
	SavingsRepository savingsRepository;

	@Autowired
	BeneficiaryAccountService beneficiaryAccountService;

	@Autowired
	CustomerService customerService;
	
	@Autowired
	TransactionService transactionService;
	
	private static final Logger logger = LoggerFactory.getLogger(SavingsService.class);

	public void getSavingsAccount(long accountNumber, long amount, long beneficiaryAccountNumber) throws InsufficientBalance {
		SavingsAccount savingsAccount;
		

		try {
			savingsAccount = savingsRepository.findById(accountNumber).get();
		} catch (Exception e) {
			throw new SavingsAccountIdNotFoundException();
		}

		if (savingsAccount.getAccountBalance() > amount) {
			savingsAccount.setAccountBalance(savingsAccount.getAccountBalance() - amount);
			BeneficiaryAccount beneficiaryAccount;
			try {

				beneficiaryAccount = beneficiaryAccountService.getBeneficiaryAccount(beneficiaryAccountNumber);
			} catch (Exception e) {
				throw new BeneficiaryAccountNotFound();

			}

			beneficiaryAccount.setAccountBalance(beneficiaryAccount.getAccountBalance() + amount);
			beneficiaryAccountService.updateBeneficiaryAccountRepository(beneficiaryAccount);
			savingsRepository.save(savingsAccount);
		} else {
			throw new InsufficientBalance("insuffecient amount ");
		}

	}

	public void getSavingsAccountByPhoneNumber(String fromPhoneNumber, int amount, String toPhoneNumber)
			throws PhoneNumberNotFoundException, CustomerNotFoundException, InsufficientBalance {
		
		Transaction transaction=new Transaction();
		SavingsAccount savingsAccount = new SavingsAccount();
		Customer customer;
		if (fromPhoneNumber.length()>=10 && fromPhoneNumber != null && toPhoneNumber != null) {
			
				customer = customerService.getCustomerByPhonumber(fromPhoneNumber);
				logger.info("getting customer details by phone number");
			if(customer==null) {
				throw new CustomerNotFoundException("please enter the phone number");
			}

			if (customer.getSavingsAccount().getAccountBalance() > amount) {

				savingsAccount.setAccountBalance(customer.getSavingsAccount().getAccountBalance() - amount);
				customer.setSavingsAccount(savingsAccount);
				BeneficiaryAccount beneficiaryAccount;
				try {

					beneficiaryAccount = beneficiaryAccountService.getBeneficiaryByPhoneNumber(toPhoneNumber);
				} catch (Exception e) {
					throw new BeneficiaryAccountNotFound();

				}

				beneficiaryAccount.setAccountBalance(beneficiaryAccount.getAccountBalance() + amount);
				beneficiaryAccountService.updateBeneficiaryAccountRepository(beneficiaryAccount);
				customerService.UpdateCustomer(customer);
				logger.info("saving customer object");
				transaction.setFromPhoneNumber(fromPhoneNumber);
				transaction.setToPhoneNumber(toPhoneNumber);
				transaction.setAmount(amount);
				transaction.setStatus(true);
				transactionService.savetransaction(transaction);
				
			} else {
				throw new InsufficientBalance(" enterd amount is greater than  the available balance ");
			}

		} else {
			throw new PhoneNumberNotFoundException("please enter the phone number");
		}
	}
}

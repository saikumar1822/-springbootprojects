package com.hcl.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.Exception.AccountNotFound;
import com.hcl.Exception.BanificiaryNotFoundException;
import com.hcl.Exception.InSufficientBalanceInAccount;
import com.hcl.Exception.UserNotfoundException;
import com.hcl.dto.TrasnsctionDto;
import com.hcl.model.Account;
import com.hcl.model.Banificiary;
import com.hcl.model.Tranfer;
import com.hcl.model.Trasnsction;
import com.hcl.model.User;
import com.hcl.repository.AccountRepositary;
import com.hcl.repository.BenificiaryRepositary;
import com.hcl.repository.T1Repo;
import com.hcl.repository.TransactionRepositary;
import com.hcl.repository.UserRepository;

@Service
public class TransactionServiceImpl implements TransacService {

	@Autowired
	BenificiaryRepositary benificiaryRepositary;
	@Autowired
	TransactionRepositary transactionRepositary;
	@Autowired
	AccountRepositary accountRepositary;
	@Autowired
	UserService userService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	T1Repo t1Repo;
	private TrasnsctionDto trasnsctionDto = new TrasnsctionDto();

	@Override
	public TrasnsctionDto transaction(Trasnsction trasnsction) {
		Account account = accountRepositary.findAccountByAccountNumber(trasnsction.getAccountNumber())
				.orElseThrow(() -> new AccountNotFound());

		if (account.getAccountBalance() >= trasnsction.getAmount()) {
			Banificiary banificiary = benificiaryRepositary
					.findBanificiaryByBanificiaryAccountNo(trasnsction.getBanificiaryAccountNo())
					.orElseThrow(() -> new BanificiaryNotFoundException());
			if (banificiary.getAccount().getAccountNumber() == trasnsction.getAccountNumber()) {

				banificiary.setBalance(banificiary.getBalance() + trasnsction.getAmount());

				benificiaryRepositary.save(banificiary);

				account.setAccountBalance(account.getAccountBalance() - trasnsction.getAmount());

				accountRepositary.save(account);

				trasnsction.setStatus(true);

				transactionRepositary.save(trasnsction);
				BeanUtils.copyProperties(trasnsction, trasnsctionDto);
				return trasnsctionDto;
			} else {
				trasnsction.setStatus(false);
				transactionRepositary.save(trasnsction);
				throw new BanificiaryNotFoundException();
			}
		} else {
			throw new InSufficientBalanceInAccount();

		}

	}

	@Override
	public Tranfer createTransac(Tranfer t1) {
		User user = userService.getByPhone(t1.getPhoneNo());
		if (user == null) {
			throw new UserNotfoundException("user with given phoneNo is not found");
		}

		User ben = userService.getByPhone(t1.getToPhoneNo());
		if (ben == null) {
			throw new UserNotfoundException("user with given phoneNo is not found");
		}

		if (user.getAccount().getAccountBalance() > t1.getAmount()) {
	System.out.println(user.getAccount().getAccountBalance());
	
			user.getAccount().setAccountBalance(user.getAccount().getAccountBalance() - t1.getAmount());
			userRepository.save(user);
			ben.getAccount().setAccountBalance(ben.getAccount().getAccountBalance() + t1.getAmount());
			userRepository.save(ben);
			return t1Repo.save(t1);

		} else {
			throw new InSufficientBalanceInAccount();
		}

	}

}

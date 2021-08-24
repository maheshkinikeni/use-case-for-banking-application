package com.banking.onlinebanking.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.onlinebanking.CustomException.InsufficientBalance;
import com.banking.onlinebanking.CustomException.InvalidAccountNumber;
import com.banking.onlinebanking.CustomException.InvalidUserNameAndPassword;
import com.banking.onlinebanking.CustomException.MaintainMinimunBalace;
import com.banking.onlinebanking.model.FundTransferInfo;
import com.banking.onlinebanking.model.User;
import com.banking.onlinebanking.model.Users;
import com.banking.onlinebanking.repository.BankRepository;

@Service
public class BankService {
	private static final Logger logger = LoggerFactory.getLogger(BankService.class);

	@Autowired
	BankRepository bankRepository;

	public Users regisiterationUsers(Users users) throws MaintainMinimunBalace {
		logger.info("enterd into regisiterationUser service");
		if (users.getBank().getBalance() < 1000) {
			throw new MaintainMinimunBalace();
		}

		return bankRepository.save(users);

	}

	public List<Users> getUsers() {
		logger.info("enterd into getUsers service");
		return (List<Users>) bankRepository.findAll();

	}

	public Users loginData(int userid) {
		logger.info("enterd into loginData service");
		return bankRepository.getById(userid);

	}

	public String findByUesrId(int userid, User user) throws InvalidUserNameAndPassword {
		logger.info("enterted into findByUserId service");

		Optional<Users> userInfo = bankRepository.findById(userid);

		Users users = userInfo.get();
		if (users.getBank().getBankId() == user.getBankId()
				&& users.getBank().getBankPassword().equals(user.getBankPassword())) {
			return "Successfully logged in";
		} else {
			throw new InvalidUserNameAndPassword();
		}

	}

	public String sendMoney(FundTransferInfo fundTransferInfo) throws InvalidAccountNumber, InsufficientBalance {
		logger.info("enterd into sendMoney service");
		Optional<Users> userinfo = bankRepository.findById(fundTransferInfo.getUserAccount());
		if (!(userinfo.isPresent())) {
			throw new InvalidAccountNumber();

		}
		Users users = userinfo.get();
		if (users.getBank().getBalance() < fundTransferInfo.getAmount()) {
			throw new InsufficientBalance();

		}

		int finalBalance = users.getBank().getBalance() - fundTransferInfo.getAmount();
		users.getBank().setBalance(finalBalance);

		bankRepository.save(users);

		return "Amount Transfered succesfully";

	}

}

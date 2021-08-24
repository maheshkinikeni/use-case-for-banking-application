package com.banking.onlinebanking.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banking.onlinebanking.CustomException.InsufficientBalance;
import com.banking.onlinebanking.CustomException.InvalidAccountNumber;
import com.banking.onlinebanking.CustomException.InvalidUserNameAndPassword;
import com.banking.onlinebanking.CustomException.MaintainMinimunBalace;
import com.banking.onlinebanking.model.FundTransferInfo;
import com.banking.onlinebanking.model.User;
import com.banking.onlinebanking.model.Users;
import com.banking.onlinebanking.service.BankService;

@RestController
public class BankController {
	private static final Logger logger = LoggerFactory.getLogger(BankController.class);
	@Autowired
	BankService bankService;

	@RequestMapping(value = "/regisiteration", method = RequestMethod.POST)
	public Users regisiterationUsers(@RequestBody Users users) throws MaintainMinimunBalace {

		logger.info("enterted into saveusers Controller");
		return bankService.regisiterationUsers(users);

	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Users> getAll() {
		logger.info("enterted into grtall controller");
		return bankService.getUsers();

	}

	@RequestMapping(value = "login/{userid}", method = RequestMethod.POST)
	public String findByUesrId(@PathVariable int userid, @RequestBody User user) throws InvalidUserNameAndPassword {
		logger.info("enterted into findByUserId Controller");

		System.out.println(user.getBankId() + "............." + user.getBankPassword());
		return (String) bankService.findByUesrId(userid, user);

	}

	@RequestMapping(value = "/fundTransfer", method = RequestMethod.POST)
	public String sendMoney(@RequestBody FundTransferInfo fundTransferInfo)
			throws InvalidAccountNumber, InsufficientBalance {
		logger.info("enterted into fundtransfer controller");
		return bankService.sendMoney(fundTransferInfo);

	}

}

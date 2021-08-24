package com.banking.onlinebanking.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banking.onlinebanking.CustomException.MaintainMinimunBalace;
import com.banking.onlinebanking.model.Beneficiary;
import com.banking.onlinebanking.model.Users;
import com.banking.onlinebanking.service.BeneficiaryService;

@RestController
public class BeneficiaryController {
	private static final Logger logger = LoggerFactory.getLogger(BeneficiaryController.class);

	@Autowired
	BeneficiaryService beneficiaryService;

	@RequestMapping(value = "/beneficiary", method = RequestMethod.POST)
	public Beneficiary saveBeniciaryData(@RequestBody Beneficiary beneficiary) throws MaintainMinimunBalace {
		logger.info("enterd into saveBeniciaryData BeneficiaryController");

		return beneficiaryService.saveData(beneficiary);

	}

	@RequestMapping(value = "/getAllBeneficiarys", method = RequestMethod.GET)
	public List<Beneficiary> getAllBeneficiarys() {
		logger.info("enterd into getAllBeneficiarys BeneficiaryController");
		return beneficiaryService.getAllBeneficiers();

	}

}
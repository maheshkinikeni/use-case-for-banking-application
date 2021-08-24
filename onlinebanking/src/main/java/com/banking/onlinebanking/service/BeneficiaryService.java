package com.banking.onlinebanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.onlinebanking.CustomException.MaintainMinimunBalace;
import com.banking.onlinebanking.model.Beneficiary;
import com.banking.onlinebanking.repository.BeneficiaryRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class BeneficiaryService {
	private static final Logger logger = LoggerFactory.getLogger(BeneficiaryService.class);
	   
	
	
	@Autowired
	BeneficiaryRepository beneficiaryRepository;
	
	public Beneficiary saveData(Beneficiary beneficiary) throws MaintainMinimunBalace{
		logger.info("enterted into Beneficiary controller");
		
		if(beneficiary.getBalance()<1000)
		{
			throw new MaintainMinimunBalace();
		}
		return beneficiaryRepository.save(beneficiary) ;
		
	}
	

	  public List<Beneficiary> getAllBeneficiers(){ 
		  return  (List<Beneficiary>) beneficiaryRepository.findAll();
	  
	  }
	 

	


}

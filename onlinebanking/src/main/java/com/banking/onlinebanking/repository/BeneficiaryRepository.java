package com.banking.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.onlinebanking.model.Beneficiary;
import com.banking.onlinebanking.model.Users;

public interface BeneficiaryRepository  extends JpaRepository<Beneficiary, Integer>{
	
	

}

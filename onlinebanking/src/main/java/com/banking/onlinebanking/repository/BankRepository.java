package com.banking.onlinebanking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banking.onlinebanking.model.Users;

@Repository
public interface BankRepository extends JpaRepository<Users, Integer>{
	

public Optional<Users> findById(Integer id);
	
	
	
	
	

}

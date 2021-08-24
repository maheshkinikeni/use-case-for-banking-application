package com.banking.onlinebanking.CustomException;

public class InvalidAccountNumber extends Exception{
	
	public InvalidAccountNumber()
	{
		super("Please enter valid AccountNumber");
	}
	

}

package com.banking.onlinebanking.CustomException;

public class InsufficientBalance extends Exception{
	
	public InsufficientBalance()
	{
		super("Please maintain sufficient balance to transfer amount");
	}

}

package com.banking.onlinebanking.CustomException;

public class InvalidUserNameAndPassword extends Exception {

	public InvalidUserNameAndPassword() {
		super("Please enter valid userid and password");
	}

}

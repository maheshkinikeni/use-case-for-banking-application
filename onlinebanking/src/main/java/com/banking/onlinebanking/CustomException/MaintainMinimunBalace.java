package com.banking.onlinebanking.CustomException;

public class MaintainMinimunBalace extends Exception {

	public MaintainMinimunBalace() {
		super("Please maintain minimun 1000 balance");
	}

}

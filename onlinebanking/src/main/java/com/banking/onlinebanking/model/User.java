package com.banking.onlinebanking.model;

public class User {
	private int bankId;
	private String bankPassword;

	public User(int i, String string) {
		// TODO Auto-generated constructor stub
	}

	

	public User() {
		// TODO Auto-generated constructor stub
	}



	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankPassword() {
		return bankPassword;
	}

	public void setBankPassword(String bankPassword) {
		this.bankPassword = bankPassword;
	}

	@Override
	public String toString() {
		return "User [bankId=" + bankId + ", bankPassword=" + bankPassword + "]";
	}

}

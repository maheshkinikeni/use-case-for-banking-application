package com.banking.onlinebanking.model;

import javax.persistence.Entity;


public class FundTransferInfo {
	
    private int userAccount;
	private int amount;
	private int benificieryAccount;
	public int getUserAccount() {
		return userAccount;
	}
    public void setUserAccount(int userAccount) {
		this.userAccount = userAccount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getBenificieryAccount() {
		return benificieryAccount;
	}
	public void setBenificieryAccount(int benificieryAccount) {
		this.benificieryAccount = benificieryAccount;
	}
	@Override
	public String toString() {
		return "FundTransferInfo [userAccount=" + userAccount + ", amount=" + amount + ", benificieryAccount="
				+ benificieryAccount + "]";
	}
	
	

}

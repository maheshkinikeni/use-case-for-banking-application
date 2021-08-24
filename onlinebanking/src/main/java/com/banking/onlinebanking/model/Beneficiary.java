package com.banking.onlinebanking.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Beneficiary {
	@Id
	private int bankId;
	private String bankName;
	private int balance;

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Beneficiary [bankId=" + bankId + ", bankName=" + bankName + ", balance=" + balance + "]";
	}

}

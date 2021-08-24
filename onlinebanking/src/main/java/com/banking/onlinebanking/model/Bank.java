package com.banking.onlinebanking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;

@Entity
public class Bank {
	@Id
	private int bankId;
	@NotNull
	private String bankName;
	@NotNull
	private String bankPassword;
	@NotNull
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
	public String getBankPassword() {
		return bankPassword;
	}
	public void setBankPassword(String bankPassword) {
		this.bankPassword = bankPassword;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", bankPassword=" + bankPassword + ", balance="
				+ balance + "]";
	}
	public Bank(int bankId, String bankName, String bankPassword, int balance) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.bankPassword = bankPassword;
		this.balance = balance;
	}
	public Bank() {
		
		
	}

}

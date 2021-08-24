package com.banking.onlinebanking.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;

import jdk.jfr.DataAmount;

@Entity
public class Users {
	@Id
	@GeneratedValue
	private int userId;
	@NotNull
	private String userName;
	@NotNull
	private String userAge;
	@NotNull
	private String userPhoneNumber;
	@NotNull
	private String userPanNumber;
	
	@OneToOne(targetEntity = Bank.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "bankId")
	private Bank bank;
	public Users(int userId, String userName, String userAge, String userPhoneNumber, String userPanNumber, Bank bank) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAge = userAge;
		this.userPhoneNumber = userPhoneNumber;
		this.userPanNumber = userPanNumber;
		this.bank = bank;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", userAge=" + userAge + ", userPhoneNumber="
				+ userPhoneNumber + ", userPanNumber=" + userPanNumber + ", bank=" + bank + "]";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAge() {
		return userAge;
	}
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	public String getUserPanNumber() {
		return userPanNumber;
	}
	public void setUserPanNumber(String userPanNumber) {
		this.userPanNumber = userPanNumber;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public Users() {
		
	}
	
	
	

}

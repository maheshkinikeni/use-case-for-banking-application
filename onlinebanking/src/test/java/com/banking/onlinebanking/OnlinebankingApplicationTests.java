package com.banking.onlinebanking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.banking.onlinebanking.CustomException.InsufficientBalance;
import com.banking.onlinebanking.CustomException.InvalidAccountNumber;
import com.banking.onlinebanking.CustomException.InvalidUserNameAndPassword;
import com.banking.onlinebanking.CustomException.MaintainMinimunBalace;
import com.banking.onlinebanking.controller.BankController;
import com.banking.onlinebanking.model.Bank;
import com.banking.onlinebanking.model.FundTransferInfo;
import com.banking.onlinebanking.model.User;
import com.banking.onlinebanking.model.Users;
import com.banking.onlinebanking.repository.BankRepository;
import com.banking.onlinebanking.service.BankService;

@SpringBootTest
class OnlinebankingApplicationTests {

	@Test
	void contextLoads() {

	}

	static Bank bank;
	static User user;
	static FundTransferInfo fundTransferInfo;

	@Autowired
	private BankService bankService;

	@MockBean
	private BankRepository bankRepository;

	@BeforeAll
	public static void setUp() {
		bank = new Bank();
		bank.setBalance(5000);
		bank.setBankId(105);
		bank.setBankName("SBI");
		bank.setBankPassword("PASSWORD");
	}

	@BeforeAll
	public static void userSetUp() {
		user = new User();
		user.setBankId(105);
		user.setBankPassword("PASSWORD");
		
	}
	
	@BeforeAll
	public static void fundTransferInfoSetUp() {
		fundTransferInfo=new FundTransferInfo();
		fundTransferInfo.setAmount(500);
		fundTransferInfo.setBenificieryAccount(115);
		fundTransferInfo.setUserAccount(1);
	}

	@Test
	public void regisiterationUsersTest() throws MaintainMinimunBalace {

		Users users = new Users(1, "rjau", "52", "98552554", "raju454", bank);
		when(bankRepository.save(users)).thenReturn(users);
		assertEquals(users, bankService.regisiterationUsers(users));
	}

	@Test
	public void getUsersTest() {
		when(bankRepository.findAll()).thenReturn(
				Stream.of(new Users(1, "babu", "25", "98552121", "babu454", bank)).collect(Collectors.toList()));
		assertEquals(1, bankService.getUsers().size());

	}

	@Test
	public void findByUesrIdTest() throws InvalidUserNameAndPassword {

		Optional<Users> users = Optional.ofNullable(new Users(1, "rjau", "52", "98552554", "raju454", bank));
		Integer userid = users.get().getUserId();
		when(bankRepository.findById(userid)).thenReturn(users);
		assertEquals("Successfully logged in", bankService.findByUesrId(userid, user));

	}
	@Test
	public void sendMoneyTest() throws InvalidAccountNumber, InsufficientBalance {
		Optional<Users> users = Optional.ofNullable(new Users(1, "rjau", "52", "98552554", "raju454", bank));
		Integer userid = users.get().getUserId();
		when(bankRepository.findById(userid)).thenReturn(users);
		int finalBalance = users.get().getBank().getBalance() - fundTransferInfo.getAmount();
		users.get().getBank().setBalance(finalBalance);
		assertEquals("Amount Transfered succesfully", bankService.sendMoney(fundTransferInfo));
		
	}
}
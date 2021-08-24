package com.banking.onlinebanking.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.banking.onlinebanking.CustomException.InsufficientBalance;
import com.banking.onlinebanking.CustomException.InvalidAccountNumber;
import com.banking.onlinebanking.CustomException.InvalidUserNameAndPassword;
import com.banking.onlinebanking.CustomException.MaintainMinimunBalace;

@ControllerAdvice
public class MyExceptionHandller {

	@ExceptionHandler(value = InvalidUserNameAndPassword.class)
	public ResponseEntity<Object> invalidNameExp(InvalidUserNameAndPassword invalid) {

		return new ResponseEntity<>(invalid.getLocalizedMessage(), HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(value = MaintainMinimunBalace.class)
	public ResponseEntity<Object> minBalanceExp(MaintainMinimunBalace invalid) {

		return new ResponseEntity<>(invalid.getLocalizedMessage(), HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(value = InsufficientBalance.class)
	public ResponseEntity<Object> insufficientBalance(InsufficientBalance invalid) {
		return new ResponseEntity<>(invalid.getLocalizedMessage(), HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(value = InvalidAccountNumber.class)
	public ResponseEntity<Object> invalidAccountNumber(InvalidAccountNumber invalid) {
		return new ResponseEntity<>(invalid.getLocalizedMessage(), HttpStatus.BAD_REQUEST);

	}

}

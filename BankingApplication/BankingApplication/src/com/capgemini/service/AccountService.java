package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;

public interface AccountService {
	
	Account createAccount(int accNumber, int amount) throws InsufficientInitialAmountException;
	
	int depositAmount(int accNumber, int amount) throws InvalidAccountNumberException;
	
	int withdrawAmount(int accNumber, int amount) throws InsufficientBalanceException, InvalidAccountNumberException;

}

package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.repository.AccountRepository;
import com.capgemini.repository.AccountRepositoryImpl;

public class AccountServiceImpl implements AccountService{

	AccountRepository accountRepository = new AccountRepositoryImpl();
	
	
	@Override
	public Account createAccount(int accNumber, int amount) throws InsufficientInitialAmountException {

		if(amount < 500)
		{
			throw new InsufficientInitialAmountException();
		}
		
		Account account = new Account();
		account.setAmount(amount);
		account.setNumber(accNumber);
		
		if(accountRepository.save(account))
		{
			return account;
		}
		
		return null;
	}


	@Override
	public int depositAmount(int accNumber, int amount) throws InvalidAccountNumberException {
			
		
		Account account = accountRepository.searchAccount(accNumber);
		
		if(account == null)
		{
			throw new InvalidAccountNumberException();
		}

		return account.getAmount() + amount;
		
	}

	@Override
	public int withdrawAmount(int accNumber, int amount)
			throws InsufficientBalanceException, InvalidAccountNumberException {

		if(accNumber < 0)
		{
			throw new InvalidAccountNumberException();
		}
		
		if(amount <= 0)
		{
			throw new InsufficientBalanceException();
		}
		
		return 1000 - amount;
	}
	
	/*@Override
	public Account searchAccount(int accountNumber) throws InvalidAccountNumberException {
		for(Account account : accounts)
		{
			if(account.getNumber()==accountNumber)
			{
				return account;
			}
		}
		throw new InvalidAccountNumberException();
	}*/
	
}

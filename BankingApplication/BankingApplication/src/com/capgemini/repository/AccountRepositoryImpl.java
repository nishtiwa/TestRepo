package com.capgemini.repository;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InvalidAccountNumberException;

public class AccountRepositoryImpl implements AccountRepository{

	List<Account> accounts = new LinkedList<>();
	
	@Override
	public boolean save(Account account) {
		accounts.add(account);
		return true;
	}

	@Override
	public Account searchAccount(int accountNumber) {
		for(Account account : accounts)
		{
			if(account.getNumber()==accountNumber)
			{
				return account;
			}
		}
		return null;
		//throw new InvalidAccountNumberException();
	}
	
}

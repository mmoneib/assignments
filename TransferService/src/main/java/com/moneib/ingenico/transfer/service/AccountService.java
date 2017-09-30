package com.moneib.ingenico.transfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneib.ingenico.transfer.data.access.AccountRepository;
import com.moneib.ingenico.transfer.data.model.Account;

/**
 * The Class AccountService provides the business logic related to accounts.
 */
@Service
public class AccountService {

	/** The repoository for accounts CRUD actions. */
	@Autowired
	private AccountRepository repo;

	/**
	 * Creates a new account.
	 *
	 * @param name
	 *            the name of the account
	 * @param balance
	 *            the balance to start with
	 * @return the created account
	 */
	public Account createAccount(String name, double balance) {
		Account account = new Account(name, balance);
		repo.save(account);

		return account;
	}

	/**
	 * Update an existing account. The method throws an
	 * {@link IllegalArgumentException} in case the account is updated with a
	 * negative balance.
	 * 
	 * This method doesn't return an object because the account is update in
	 * place.
	 *
	 * @param account
	 *            the account to be updated
	 */
	public void updateAccount(Account account) {
		if (!checkBalance(account)) {
			throw new IllegalArgumentException("Accounts must have +ve balance.");
		}
		repo.save(account);
	}

	/**
	 * Gets the account by the specified id.
	 *
	 * @param id
	 *            the id
	 * @return the account
	 */
	public Account getAccountById(long id) {
		return repo.findOne(id);
	}

	/**
	 * Gets the account by the specified name.
	 *
	 * @param name
	 *            the name
	 * @return the account
	 */
	public Account getAccountByName(String name) {
		return repo.findByName(name);
	}

	/**
	 * Checks the balance to make sure that it is zero or more.
	 *
	 * @param account
	 *            the account
	 * @return true, if not negative
	 */
	private boolean checkBalance(Account account) {
		if (account.getBalance() < 0) {
			return false;
		}
		return true;
	}
}

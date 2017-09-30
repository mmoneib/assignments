package com.moneib.ingenico.transfer.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneib.ingenico.transfer.data.access.TransferRepository;
import com.moneib.ingenico.transfer.data.model.Account;
import com.moneib.ingenico.transfer.data.model.Transfer;

/**
 * The Class TransferService provides the business logic related to money
 * transfers.
 */
@Service
public class TransferService {

	/** The repository for transfers CRUD actions. */
	@Autowired
	private TransferRepository repo;

	/**
	 * The account service. This is needed as money transfers involve accounts.
	 */
	@Autowired
	private AccountService accountService;

	/**
	 * Make transfer of money from one account to another. It throws an
	 * {@link IllegalArgumentException} in case one or both of the accounts are
	 * null.
	 * 
	 * This method is meant to be atomic; no simultaneous writing is allowed on
	 * the records to maintain data integrity.
	 *
	 * @param sourceName
	 *            the name of the source account
	 * @param destinationName
	 *            the name of the destination account
	 * @param amount
	 *            the amount of money transferred in Euros
	 * @return the transfer
	 */
	@Transactional(value = TxType.REQUIRES_NEW, rollbackOn = { Throwable.class })
	public Transfer makeTransfer(String sourceName, String destinationName, double amount) {
		Account source = accountService.getAccountByName(sourceName);
		Account destination = accountService.getAccountByName(destinationName);

		if (!checkAvailabilityOfSourceAndDest(source, destination)) {
			throw new IllegalArgumentException("Source and destination accounts must be valid.");
		}

		calculateNewBalances(source, destination, amount);
		accountService.updateAccount(source);
		accountService.updateAccount(destination);

		return repo.save(new Transfer(source, destination, amount));
	}

	/**
	 * Calculate new balances after a transfer.
	 *
	 * @param source
	 *            the source account
	 * @param destination
	 *            the destination account
	 * @param amount
	 *            the amount to be transferred in Euros
	 */
	private void calculateNewBalances(Account source, Account destination, double amount) {
		source.setBalance(source.getBalance() - amount);
		destination.setBalance(destination.getBalance() + amount);
	}

	/**
	 * Check availability of source and destination accounts.
	 *
	 * @param source
	 *            the source account
	 * @param destination
	 *            the destination account
	 * @return true, if both accounts ar not null
	 */
	private boolean checkAvailabilityOfSourceAndDest(Account source, Account destination) {
		if (source == null || destination == null) {
			return false;
		}
		return true;
	}
}

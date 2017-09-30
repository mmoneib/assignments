package com.moneib.ingenico.transfer.data.access;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.moneib.ingenico.transfer.data.model.Account;

/**
 * The Interface AccountRepository provides CRUD capabilites for the Account
 * entity.
 */
@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

	/**
	 * Find an account by name. This should return only one account.
	 *
	 * @param name
	 *            the name of the required account
	 * @return the account
	 */
	public Account findByName(String name);
}

package com.moneib.ingenico.transfer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moneib.ingenico.transfer.data.model.Account;
import com.moneib.ingenico.transfer.service.AccountService;

/**
 * The Class AccountController provides a RESTful API for performing actions on
 * accounts.
 */
@RestController
@RequestMapping(path = "/accounts")
public class AccountController {

	/** The service layer for the Account entity. */
	@Autowired
	private AccountService service;

	/**
	 * Creates the account with initial balance.
	 *
	 * @param name
	 *            the name of the acount
	 * @param balance
	 *            the balance with which the account will start
	 * @return the response entity
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/add")
	public ResponseEntity<Account> createAccount(@RequestParam String name, @RequestParam String balance) {
		Account account = service.createAccount(name, Double.valueOf(balance));

		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
}

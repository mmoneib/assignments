package com.moneib.ingenico.transfer.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.moneib.ingenico.transfer.data.access.AccountRepository;
import com.moneib.ingenico.transfer.data.model.Account;
import com.moneib.ingenico.transfer.service.AccountService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.moneib.ingenico.transfer.TransferServiceApplication.class)
public class AccountServiceTests {
	@Autowired
	AccountService accountService;
	@Autowired
	AccountRepository accountRepository;

	@Test
	public void testCreateAccountSuccess() {
		Account account = accountService.createAccount("account3", 20);

		assertEquals(account.getName(), "account3");
		assertEquals(account.getBalance(), 20, 0);
		assertTrue(account.getId() > 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUpdateAccountFailDueToNegativeBalance() {
		Account account = new Account("account", -20);
		accountService.updateAccount(account);
	}

	@Test
	public void testUpdateAccountSuccess() {
		Account account = new Account("account2", 20);

		accountService.updateAccount(account);

		Account updatedAccount = accountRepository.findByName(account.getName());

		assertEquals(account.getName(), updatedAccount.getName());
		assertEquals(account.getBalance(), updatedAccount.getBalance(), 0);
		assertTrue(updatedAccount.getId() > 0);
	}

	@Test
	public void testGetAccountByIdSuccess() {
		Account account = new Account("account4", 20);
		account = accountRepository.save(account);

		Account retrievedAccount = accountRepository.findOne(account.getId());

		assertEquals(account, retrievedAccount);
	}

	@Test
	public void testGetAccountByNameSuccess() {
		Account account = new Account("account5", 20);
		account = accountRepository.save(account);

		Account retrievedAccount = accountRepository.findByName(account.getName());

		assertEquals(account, retrievedAccount);
	}
}

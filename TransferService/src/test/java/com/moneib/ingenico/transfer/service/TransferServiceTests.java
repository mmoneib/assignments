package com.moneib.ingenico.transfer.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.moneib.ingenico.transfer.data.access.AccountRepository;
import com.moneib.ingenico.transfer.data.model.Account;
import com.moneib.ingenico.transfer.service.TransferService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.moneib.ingenico.transfer.TransferServiceApplication.class)
public class TransferServiceTests {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransferService transferService;

	@Test(expected = IllegalArgumentException.class)
	public void makeTransferFailureDueToNegativeBalance() {
		Account source = new Account("source1", 20);
		Account destination = new Account("destination1", 25);

		accountRepository.save(source);
		accountRepository.save(destination);

		transferService.makeTransfer(source.getName(), destination.getName(), 21);
	}

	@Test
	public void makeTransferSuccess() {
		Account source = new Account("source2", 40);
		Account destination = new Account("destination2", 25);

		accountRepository.save(source);
		accountRepository.save(destination);

		transferService.makeTransfer(source.getName(), destination.getName(), 21);

		assertEquals(source.getBalance() - 21, accountRepository.findByName("source2").getBalance(), 0);
		assertEquals(destination.getBalance() + 21, accountRepository.findByName("destination2").getBalance(), 0);

	}
}

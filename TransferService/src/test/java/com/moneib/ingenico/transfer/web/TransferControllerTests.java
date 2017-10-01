package com.moneib.ingenico.transfer.web;

import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.moneib.ingenico.transfer.data.model.Account;
import com.moneib.ingenico.transfer.data.model.Transfer;
import com.moneib.ingenico.transfer.service.TransferService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class TransferControllerTests {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private TransferService service;

	@Test
	public void testMakeTransfer() throws Exception {
		Transfer transfer = new Transfer(new Account("source", 121), new Account("destination", 131), 11);

		given(service.makeTransfer(transfer.getSourceAccount().getName(), transfer.getDestinationAccount().getName(),
				transfer.getAmount())).willReturn(transfer);

		mvc.perform(post("/transfers/transfer").param("source", "source").param("destination", "destination")
				.param("amount", "11").with(user("user").password("passw0rd"))).andExpect(status().isOk())
				.andExpect(jsonPath("sourceAccount.name").value("source")).andExpect(jsonPath("destinationAccount.name").value("destination"))
				.andExpect(jsonPath("amount").value("11.0"));
	}
}

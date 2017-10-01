package com.moneib.ingenico.transfer.web;

import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.moneib.ingenico.transfer.data.model.Account;
import com.moneib.ingenico.transfer.service.AccountService;
import com.moneib.ingenico.transfer.service.TransferService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class AccountControllerTests {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private AccountService service;

	@Test
	public void testCreateAccount() throws Exception {
		Account account = new Account("test", 110);

		given(service.createAccount(account.getName(), account.getBalance())).willReturn(account);

		mvc.perform(post("/accounts/add").param("name", "test").param("balance", "110")
				.with(user("user").password("passw0rd"))).andExpect(status().isOk())
				.andExpect(jsonPath("name").value("test")).andExpect(jsonPath("balance").value("110.0"));
	}

}

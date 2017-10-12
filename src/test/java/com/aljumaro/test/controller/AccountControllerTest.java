package com.aljumaro.test.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.aljumaro.test.repository.Account;
import com.aljumaro.test.repository.AccountNumber;
import com.aljumaro.test.service.AccountService;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private AccountService accountService;

	@Test
	public void getUserAccountShouldReturnAccounts() throws Exception {
		// given
		String content = "[{\"name\":\"user\",\"accountNumber\":{\"number\":123456}}]";
		given(accountService.findAccounts()).willReturn(
				Collections.singletonList(new Account("user", AccountNumber.builder().number(123456).build())));

		// when
		ResultActions result = mvc.perform(get("/v1/accounts").accept(MediaType.APPLICATION_JSON));

		// then
		result.andExpect(status().isOk()).andExpect(content().json(content));
	}
}

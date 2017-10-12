package com.aljumaro.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.aljumaro.test.repository.Account;
import com.aljumaro.test.repository.AccountRepository;

@RunWith(SpringRunner.class)
public class AccountServiceTest {

	@MockBean
	private AccountRepository accountRepository;

	@MockBean
	private UserService userRepository;

	private AccountService accountService;

	@Before
	public void before() {
		accountService = new AccountService(accountRepository, userRepository);
	}

	@Test
	public void getUserAccountsGetSingleAccount() {
		given(accountRepository.findByName("user"))
				.willReturn(Collections.singletonList(new Account(0, "user", 123456789)));

		given(userRepository.getAuthenticatedUser()).willReturn(User.builder().name("user").build());

		// when
		List<Account> accounts = accountService.findAccounts();

		// then
		assertThat(accounts).as("Size must be one").size().isEqualTo(1);
		assertThat(accounts.get(0).getName()).as("User must be same").isEqualTo("user");
		assertThat(accounts.get(0).getAccountNumber()).as("Account number must be same").isEqualTo(123456789);
	}
}

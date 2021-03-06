package com.aljumaro.test.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aljumaro.test.repository.Account;
import com.aljumaro.test.repository.AccountRepository;

@Service
public class AccountService {

	private AccountRepository accountRepository;
	private UserService userRepository;

	public AccountService(AccountRepository accountRepository, UserService userRepository) {
		this.accountRepository = accountRepository;
		this.userRepository = userRepository;
	}

	public List<Account> findAccounts() {
		//@formatter:off
		
		return Optional.ofNullable(userRepository.getAuthenticatedUser())
				.map(u -> accountRepository.findByName(u.getName()))
				.orElse(Collections.emptyList());
		
		//@formatter:on
	}
}

package com.aljumaro.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aljumaro.test.repository.Account;
import com.aljumaro.test.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	@GetMapping("/v1/accounts")
	public List<Account> findAll() {
		return accountService.findAccounts();
	}
}

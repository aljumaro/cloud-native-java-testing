package com.aljumaro.test.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private AccountNumber accountNumber;

}

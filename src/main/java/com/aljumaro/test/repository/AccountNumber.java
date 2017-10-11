package com.aljumaro.test.repository;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Builder
@EqualsAndHashCode
public class AccountNumber {

	@Getter
	@Setter
	private int number;

}

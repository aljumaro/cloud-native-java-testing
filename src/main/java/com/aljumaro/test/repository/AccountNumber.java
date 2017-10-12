package com.aljumaro.test.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Builder
@EqualsAndHashCode
@Entity
public class AccountNumber {

	@Getter
	@Setter
	@Id
	private int id;

	@Getter
	@Setter
	private int number;

}

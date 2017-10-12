package com.aljumaro.test.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {

	@Getter
	@Setter
	@Id
	private int id;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private int accountNumber;

}

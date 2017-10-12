package com.aljumaro.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	public List<Account> findByName(String name);

}

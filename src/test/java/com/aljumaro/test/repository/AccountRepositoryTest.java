package com.aljumaro.test.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void testFindByName() {
		// given
		this.entityManager.persist(Account.builder().name("user").accountNumber(123456).build());

		// when
		List<Account> result = accountRepository.findByName("user");

		// then
		assertThat(result.get(0).getAccountNumber()).isEqualTo(123456);
		assertThat(result.get(0).getName()).isEqualTo("user");
	}
}

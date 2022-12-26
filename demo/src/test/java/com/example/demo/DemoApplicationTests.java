package com.example.demo;

import com.example.demo.account.entity.Account;
import com.example.demo.account.vo.Email;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void createNewAccountTest () {
		final int testId = 3;
		Email email = new Email("test@test.com");

		Account account = new Account(testId, email);
		System.out.println(account);
	}

	@Test
	void contextLoads() {
	}

}

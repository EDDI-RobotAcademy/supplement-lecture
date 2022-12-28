package com.example.demo;

import com.example.demo.domain.account.entity.Account;
import com.example.demo.domain.common.vo.Email;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DemoApplicationTests {

	// 테스트를 작성하는 방법
	// @Test를 작성하면 단위 테스트를 하겠다는 의미가 됨
	// 이와 같은 테스트 코드가 작성되면 좋은점

	// 1. 테스트 코드만 보고서도 해당 Domain의 구동 방식을 파악할 수 있게 됨
	// 2. 부가적으로 어제 디버깅 하면서 핸들링 했던 상황을 좀 더 편하게 제어할 수 있게 됨
	@Test
	void 새로운_이메일_계정_생성시_이메일_유효성_검사 () {
		final int testId = 3;
		// 실제에서는 new Email(requestedEmailString);
		Email email = new Email("test@test.com");
		Boolean isValidEmail = email.checkEmailValidation();

		// 결론적으로 현재 구성한 작업들에서
		// 실패할 케이스는 어떤 상황이고
		// 성공할 케이스는 어떤 상황인지 개발자가 가늠하여
		// assertTrue 및 assertFalse를 배치하고
		// 각각의 케이스가 정상적으로 잘 작동하는지 검사한다고 보면 되겠습니다.

		// 결국 assertFalse 및 assertTrue를 기대값을 배치한다 보면 됩니다.
		// 기대값: 내 예측은 실패야 혹은 성공이야 같은 정보입니다 (true / false)
		assertFalse(isValidEmail);
		// assertTrue(isValidEmail);
		//Account account = new Account(testId, email);
		//System.out.println(account);
	}

	@Test
	void contextLoads() {
	}

}

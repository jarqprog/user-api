package com.jarqprog.userapi

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserApiApplicationTests {

	@Test
	fun `Just dummy test`() {
//		val address = WriteAddress("any@gmail.com")
//		val writeUser = UserEntity("anyLogin", address, "name")
		println(">> dummy test")
//		println(writeUser)
		assertThat(200).isEqualTo(2_00)
	}
}
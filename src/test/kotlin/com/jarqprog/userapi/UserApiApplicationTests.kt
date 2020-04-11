package com.jarqprog.userapi

import com.jarqprog.userapi.writeuser.address.WriteAddress
import com.jarqprog.userapi.writeuser.WriteUser
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserApiApplicationTests {

	@Test
	fun `Just dummy test`() {
		val address = WriteAddress("any@gmail.com")
		val writeUser = WriteUser("anyLogin", address, "name")
		println(">> dummy test")
		println(writeUser)
		assertThat(200).isEqualTo(2_00)
	}
}
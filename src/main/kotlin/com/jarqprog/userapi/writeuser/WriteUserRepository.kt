package com.jarqprog.userapi.writeuser

import com.jarqprog.userapi.domain.UserModel
import org.springframework.data.repository.CrudRepository

interface WriteUserRepository: CrudRepository<UserModel, String>
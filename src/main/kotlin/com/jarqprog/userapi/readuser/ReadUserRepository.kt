package com.jarqprog.userapi.readuser

import com.jarqprog.userapi.domain.UserModel
import org.springframework.data.repository.CrudRepository

interface ReadUserRepository: CrudRepository<UserModel, String>
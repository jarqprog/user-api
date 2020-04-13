package com.jarqprog.userwriteapi.writeuser

import com.jarqprog.userwriteapi.domain.UserModel
import org.springframework.data.repository.CrudRepository

interface WriteUserRepository: CrudRepository<UserModel, String>
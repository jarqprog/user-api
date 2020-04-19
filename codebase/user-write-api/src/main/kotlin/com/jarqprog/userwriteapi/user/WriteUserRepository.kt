package com.jarqprog.userwriteapi.user

import org.springframework.data.repository.CrudRepository

interface WriteUserRepository: CrudRepository<User, String>
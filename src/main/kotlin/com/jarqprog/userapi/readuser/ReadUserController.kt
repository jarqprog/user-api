package com.jarqprog.userapi.readuser

import com.jarqprog.userapi.domain.User
import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException

@RestController
@RequestMapping("/api/user")
class ReadUserController(private val repository: ReadUserRepository) {

    @GetMapping("/{login}")
    fun findOne(@PathVariable login: String): User = repository.findById(login)
            .orElseThrow{ RuntimeException("User not found by login {$login}") }
}
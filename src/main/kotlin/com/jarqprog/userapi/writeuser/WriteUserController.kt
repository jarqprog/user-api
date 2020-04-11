package com.jarqprog.userapi.writeuser

import com.jarqprog.userapi.domain.User
import com.jarqprog.userapi.domain.UserModel
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user")
class WriteUserController(private val repository: WriteUserRepository) {

    @PostMapping
    fun save(@RequestBody user: User) {
        repository.save(UserModel(user))
    }

    @PutMapping
    fun update(@RequestBody user: User) {
        repository.save(UserModel(user))
    }
}
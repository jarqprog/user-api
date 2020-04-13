package com.jarqprog.userwriteapi.writeuser

import com.jarqprog.userwriteapi.domain.User
import com.jarqprog.userwriteapi.domain.UserModel
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
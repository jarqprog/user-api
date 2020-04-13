package com.jarqprog.userwriteapi.user

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user")
class WriteUserController(private val repository: WriteUserRepository) {

    @PostMapping
    fun save(@RequestBody user: User) {
        repository.save(User(user))
    }

    @PutMapping
    fun update(@RequestBody user: User) {
        repository.save(User(user))
    }
}
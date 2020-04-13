package com.jarqprog.userwriteapi.readuser

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class ReadUserController(@Autowired private val userFinder: UserFinder) {

    @GetMapping("/{login}")
    fun findOne(@PathVariable login: String): ResponseEntity<UserFinder.JsonUser> {
        return ResponseEntity.of(userFinder.findBy(login))
    }
}
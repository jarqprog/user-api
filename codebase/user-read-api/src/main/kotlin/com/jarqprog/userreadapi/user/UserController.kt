package com.jarqprog.userreadapi.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController(@Autowired private val reader: Reader) {

    @GetMapping("/{login}")
    fun findOne(@PathVariable login: String): ResponseEntity<JsonUser> {
        return ResponseEntity.of(reader.findBy(login))
    }
}

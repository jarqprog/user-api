package com.jarqprog.userapi.readuser

import com.jarqprog.userapi.domain.UserModel
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/user")
class ReadUserController(private val repository: ReadUserRepository) {

    val log = LoggerFactory.getLogger(ReadUserController::class.simpleName)

    @GetMapping("/{login}")
    fun findOne(@PathVariable login: String): ResponseEntity<UserModel> {
        val optionalUser = repository.findById(login)
                .map { optionalUser ->
                    log.info("about to call by User with login: $login")
                    optionalUser
                 }
                .map { optionalUser -> UserModel(optionalUser) }
                .or {
                    log.warn("User not found by login: $login")
                    Optional.empty()
                }

        return ResponseEntity.of(optionalUser)
    }
}
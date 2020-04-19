package com.jarqprog.userreadapi.status

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/_status")
class StatusController() {

    @GetMapping
    fun status(): ResponseEntity<String> = ResponseEntity.ok("OK")
}
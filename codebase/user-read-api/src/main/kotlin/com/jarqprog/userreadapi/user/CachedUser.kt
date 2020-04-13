package com.jarqprog.userreadapi.user

import java.time.LocalDateTime
import java.util.*

data class CachedUser(val user: Optional<JsonUser>, val dateTime: LocalDateTime = LocalDateTime.now())

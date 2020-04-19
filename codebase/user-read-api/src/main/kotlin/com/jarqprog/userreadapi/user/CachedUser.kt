package com.jarqprog.userreadapi.user

import java.time.LocalDateTime
import java.util.Optional

data class CachedUser(val user: Optional<JsonUser>, private val dateTime: LocalDateTime = LocalDateTime.now()) {

    fun isOlderThan(minutesAgo: Long): Boolean = dateTime.isBefore(LocalDateTime.now().minusMinutes(minutesAgo))
    fun isNotOlderThan(minutesAgo: Long): Boolean = dateTime.isAfter(LocalDateTime.now().minusMinutes(minutesAgo))
}



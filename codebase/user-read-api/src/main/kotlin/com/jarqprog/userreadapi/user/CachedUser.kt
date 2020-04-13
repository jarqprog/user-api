package com.jarqprog.userreadapi.user

import java.time.LocalTime
import java.util.Optional

data class CachedUser(val user: Optional<JsonUser>, private val dateTime: LocalTime = LocalTime.now()) {

    fun isOlderThan(minutesAgo: Long): Boolean = dateTime.isBefore(LocalTime.now().minusMinutes(minutesAgo))
    fun isNotOlderThan(minutesAgo: Long): Boolean = dateTime.isAfter(LocalTime.now().minusMinutes(minutesAgo))
}



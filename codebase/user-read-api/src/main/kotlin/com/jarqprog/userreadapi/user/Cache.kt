package com.jarqprog.userreadapi.user

import java.time.LocalDateTime
import java.util.*
import java.util.concurrent.ConcurrentHashMap

private val userCache = ConcurrentHashMap<String,CachedUser>()

class Cache {

    fun remember(login: String, optionalUser: Optional<JsonUser>) {
        userCache[login] = CachedUser(optionalUser)
    }

    fun user(login: String) : Optional<JsonUser> {
        val tenMinutesAgo = LocalDateTime.now().minusMinutes(10)
        return Optional.ofNullable(userCache[login])
                .filter { cachedUser -> cachedUser.dateTime.isAfter(tenMinutesAgo) }
                .filter { cachedUser -> cachedUser.user.isPresent }
                .map { cachedUser -> cachedUser.user }
                .orElseGet { Optional.empty() }
    }
}
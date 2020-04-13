package com.jarqprog.userreadapi.user

import java.time.LocalDateTime
import java.util.Optional
import java.util.concurrent.ConcurrentHashMap

private const val DEFAULT_CACHE_SIZE = 1000

class Cache(cacheSize: Int = DEFAULT_CACHE_SIZE) {

    init {
        Singleton.cacheSize = cacheSize
    }

    fun remember(login: String, optionalUser: Optional<JsonUser>) {
        Singleton.remember(login, optionalUser)
    }

    fun user(login: String): Optional<JsonUser> {
        return Singleton.user(login)
    }

    private companion object Singleton {
        
        private var cache = ConcurrentHashMap<String, CachedUser>()
        private var cacheSize: Int = DEFAULT_CACHE_SIZE

        private fun remember(login: String, optionalUser: Optional<JsonUser>) {
            cache[login]= CachedUser(optionalUser)
        }

        private fun user(login: String): Optional<JsonUser> {
            val tenMinutesAgo = LocalDateTime.now().minusMinutes(10)
            return Optional.ofNullable(cache[login])
                    .filter { cachedUser -> cachedUser.dateTime.isAfter(tenMinutesAgo) }
                    .filter { cachedUser -> cachedUser.user.isPresent }
                    .map { cachedUser -> cachedUser.user }
                    .orElseGet { Optional.empty() }
        }
    }
}
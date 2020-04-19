package com.jarqprog.userreadapi.user

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.collections.ArrayList

private val CACHE = ConcurrentHashMap<String, CachedUser>()
private var isCleanInProgress =  AtomicBoolean(false)

class Cache(private val maxCacheSize: Int = 5, private val acceptableAgeInMinutes: Long = 2L) {

    fun remember(login: String, optionalUser: Optional<JsonUser>) {
        CACHE[login] = CachedUser(optionalUser)
        validateCache()
    }

    fun user(login: String): Optional<JsonUser> {
        return Optional.ofNullable(CACHE[login])
                .filter { cachedUser -> cachedUser.isNotOlderThan(acceptableAgeInMinutes) }
                .filter { cachedUser -> cachedUser.user.isPresent }
                .map { cachedUser -> cachedUser.user }
                .orElseGet { Optional.empty() }
    }

    private fun validateCache() {
        if (CACHE.size > maxCacheSize) {
            if (!isCleanInProgress.get()) cleanUp()
            // modify cache size else maxCacheSize
        }
    }

    private fun cleanUp() {
        runBlocking {
            launch(Dispatchers.Default) {
                isCleanInProgress.set(true)
                println(CACHE.toString())
                println("${Thread.currentThread()} has run.##### CLEANING")
                val toRemove = ArrayList<String>()
                CACHE.forEach { (login,cachedUser) -> if (cachedUser.isOlderThan(acceptableAgeInMinutes)) toRemove.add(login) }
                toRemove.forEach { login -> CACHE.remove(login) }
                println("${Thread.currentThread()} has run.##### CLEANED")
                println(CACHE.toString())
                isCleanInProgress.set(false)
            }
        }
    }
}




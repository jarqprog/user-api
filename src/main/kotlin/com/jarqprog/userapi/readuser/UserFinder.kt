package com.jarqprog.userapi.readuser

import com.fasterxml.jackson.annotation.JsonProperty
import com.jarqprog.userapi.UserDatabase
import com.jarqprog.userapi.domain.Address
import org.slf4j.LoggerFactory
import org.springframework.data.mongodb.core.findOne

import org.springframework.data.mongodb.core.query.Criteria.where
import org.springframework.data.mongodb.core.query.Query
import java.time.LocalDateTime
import java.util.*
import java.util.concurrent.ConcurrentHashMap

private val LOGGER = LoggerFactory.getLogger(UserFinder::class.simpleName)
private const val BSON_ID = "_id"
private val userCache = ConcurrentHashMap<String,CachedUser>()

class UserFinder(private val db: UserDatabase)  {

    fun findBy(login: String): Optional<JsonUser> {
        val tenMinutesAgo = LocalDateTime.now().minusMinutes(10)
        return Optional.ofNullable(userCache[login])
                .filter { cachedUser -> cachedUser.dateTime.isAfter(tenMinutesAgo) }
                .map { cachedUser -> cachedUser.user }
                .orElseGet {
                    Optional.of(cacheUser(login))
                        .map { userCache[login]?.user }
                        .orElseGet { Optional.empty() }
                }
    }

    private fun cacheUser(login: String) : CachedUser {
        val user = Optional.ofNullable(db.connection().findOne<JsonUser>(searchQuery(login), db.collection()))
        val cachedUser = CachedUser(user)
        userCache[login] = cachedUser
        return cachedUser
    }

    data class JsonUser(
        @JsonProperty("login") val _id: String,
        val address: Address,
        val firstName: String = "",
        val lastName: String = ""
    )

    private fun searchQuery(login: String) = Query().addCriteria(where(BSON_ID).`is`(login))
}

data class CachedUser(val user: Optional<UserFinder.JsonUser>, val dateTime: LocalDateTime = LocalDateTime.now())

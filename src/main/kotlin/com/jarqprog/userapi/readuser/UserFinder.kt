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
        return userCache.computeIfAbsent(login) { asCachedUser(login) }.user

    }

    private fun asCachedUser(login: String) : CachedUser {
        val user = Optional.ofNullable(db.connection().findOne<JsonUser>(searchQuery(login), db.collection()))
        return CachedUser(user, LocalDateTime.now())
    }

    data class JsonUser(
        @JsonProperty("login") val _id: String,
        val address: Address,
        val firstName: String = "",
        val lastName: String = ""
    )

    private fun searchQuery(login: String) = Query().addCriteria(where(BSON_ID).`is`(login))
}

private data class CachedUser(val user: Optional<UserFinder.JsonUser>, val dateTime: LocalDateTime)

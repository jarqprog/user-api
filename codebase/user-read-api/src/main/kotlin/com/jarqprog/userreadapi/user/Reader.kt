package com.jarqprog.userreadapi.user

import org.slf4j.LoggerFactory
import org.springframework.data.mongodb.core.findOne

import org.springframework.data.mongodb.core.query.Criteria.where
import org.springframework.data.mongodb.core.query.Query
import java.util.*

private val LOGGER = LoggerFactory.getLogger(Reader::class.simpleName)
private const val BSON_ID = "_id"


class Reader(private val db: Database, private val cache: Cache)  {

    fun findBy(login: String): Optional<JsonUser> {
        return Optional.of(cache.user(login))
                .filter {optionalUser -> optionalUser.isPresent }
                .orElseGet {
                    val optionalUser = Optional
                            .ofNullable(db.connection().findOne<JsonUser>(searchQuery(login), db.collection()))
                    cache.remember(login, optionalUser)
                    optionalUser
                }
    }

    private fun searchQuery(login: String) = Query().addCriteria(where(BSON_ID).`is`(login))
}


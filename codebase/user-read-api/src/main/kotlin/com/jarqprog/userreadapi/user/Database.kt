package com.jarqprog.userreadapi.user

import org.springframework.data.mongodb.core.MongoOperations

class Database(private val collection: String, private val connection: MongoOperations) {

    fun collection(): String = collection
    fun connection(): MongoOperations = connection
}
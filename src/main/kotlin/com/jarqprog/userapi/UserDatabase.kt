package com.jarqprog.userapi

import org.springframework.data.mongodb.core.MongoOperations

public class UserDatabase(private val collection: String, private val connection: MongoOperations) {

    public fun collection(): String = collection
    public fun connection(): MongoOperations = connection

}
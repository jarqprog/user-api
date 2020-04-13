package com.jarqprog.userreadapi

import com.jarqprog.userreadapi.user.Database
import com.jarqprog.userreadapi.user.Reader
import com.mongodb.client.MongoClients
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment
import org.springframework.data.mongodb.core.MongoTemplate

//to be moved to configuration module
private const val DB_NAME = "mongodb.db_name"
private const val DB_URI = "spring.data.mongodb.uri"
private const val DB_USER_COLLECTION = "mongodb.db_user_collection"

@SpringBootApplication
class UserReadApi {

    @Bean
    @Autowired
    fun database(env: Environment): Database {
        val connection = MongoTemplate(MongoClients.create(env.getRequiredProperty(DB_URI)), env.getRequiredProperty(DB_NAME))
        return Database(env.getRequiredProperty(DB_USER_COLLECTION), connection)
    }

    @Bean
    @Autowired
    fun reader(database: Database): Reader {
        return Reader(database)
    }
}

fun main(args: Array<String>) {
    runApplication<UserReadApi>(*args)
}








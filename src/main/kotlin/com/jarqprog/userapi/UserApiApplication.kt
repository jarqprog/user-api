package com.jarqprog.userapi

import com.jarqprog.userapi.readuser.UserFinder
import com.mongodb.client.MongoClients
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment
import org.springframework.data.mongodb.core.MongoTemplate

private const val DB_NAME = "mongodb.db_name"
private const val DB_URI = "spring.data.mongodb.uri"
const val DB_USER_COLLECTION = "mongodb.db_user_collection"

@SpringBootApplication
class UserApiApplication {

	@Bean
	@Autowired
	fun userDatabase(env: Environment): UserDatabase {
		val connection = MongoTemplate(MongoClients.create(env.getRequiredProperty(DB_URI)), env.getRequiredProperty(DB_NAME))
		return UserDatabase(env.getRequiredProperty(DB_USER_COLLECTION), connection)
	}

	@Bean
	@Autowired
	fun userFinder(userDatabase: UserDatabase): UserFinder {
		return UserFinder(userDatabase)
	}
}

fun main(args: Array<String>) {
	runApplication<UserApiApplication>(*args)
}

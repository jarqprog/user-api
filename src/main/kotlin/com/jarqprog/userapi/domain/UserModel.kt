package com.jarqprog.userapi.domain

import org.springframework.data.annotation.Id

class UserModel(@Id private val login: String, private val address: Address,
                private val firstName: String = "", private val lastName: String = ""): User {

    constructor(user: User): this(user.login(), user.address(), user.firstName(), user.lastName())

    override fun login(): String {
        return login
    }

    override fun address(): Address {
        return address
    }

    override fun firstName(): String {
        return firstName
    }

    override fun lastName(): String {
        return lastName
    }
}
package com.jarqprog.userapi.writeuser

import com.jarqprog.userapi.domain.Address
import com.jarqprog.userapi.domain.User

class WriteUser (private val login: String, private val address: Address,
                 private val firstName: String = "", private val lastName: String = "") : User {

    //todo login validation

    override fun login() : String {
        return login
    }

    override fun address() : Address {
        return address
    }

    override fun firstName() : String {
        return firstName
    }

    override fun lastName() : String {
        return lastName
    }
}

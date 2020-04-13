package com.jarqprog.userwriteapi.user

import com.jarqprog.userwriteapi.address.Address
import org.springframework.data.annotation.Id

data class User(@Id private val login: String, private val address: Address,
           private val firstName: String = "", private val lastName: String = "") {

    constructor(user: User): this(user.login, user.address, user.firstName, user.lastName)
}
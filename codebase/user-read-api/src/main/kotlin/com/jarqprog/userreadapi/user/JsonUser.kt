package com.jarqprog.userreadapi.user

import com.fasterxml.jackson.annotation.JsonProperty
import com.jarqprog.userreadapi.address.Address

data class JsonUser(

        @JsonProperty("login") val _id: String,
        val address: Address,
        val firstName: String = "",
        val lastName: String = ""
)
package com.jarqprog.userapi.domain

interface User {
    fun login() : String
    fun address() : Address
    fun firstName() : String
    fun lastName() : String
}

package com.jarqprog.userwriteapi.address

import java.beans.ConstructorProperties


data class Address @ConstructorProperties("email") constructor(private val email: String)
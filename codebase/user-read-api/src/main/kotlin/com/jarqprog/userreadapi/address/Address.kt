package com.jarqprog.userreadapi.address

import java.beans.ConstructorProperties

data class Address @ConstructorProperties("email") constructor(val email: String)

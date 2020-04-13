package com.jarqprog.userreadapi.address

import com.fasterxml.jackson.annotation.JsonCreator
import java.beans.ConstructorProperties

data class Address @ConstructorProperties("email") constructor(val email: String) {
//
//    @JsonCreator
//    constructor(address: Address): this(address.email)

}
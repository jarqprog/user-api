package com.jarqprog.userapi.domain

import java.beans.ConstructorProperties

public class AddressModel @ConstructorProperties("email") constructor(private val email: String) : Address {

    constructor(address: Address): this(address.email())

    override fun email(): String {
        return email
    }
}
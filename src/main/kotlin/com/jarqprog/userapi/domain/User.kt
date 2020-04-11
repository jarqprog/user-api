package com.jarqprog.userapi.domain

import com.fasterxml.jackson.annotation.JsonGetter
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonDeserialize(`as` = UserModel::class)
public interface User {

    @JsonGetter
    fun login() : String

    @JsonGetter
    fun address() : Address

    @JsonGetter
    fun firstName() : String

    @JsonGetter
    fun lastName() : String
}

package com.jarqprog.userwriteapi.domain

import com.fasterxml.jackson.annotation.JsonGetter
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonDeserialize(`as` = AddressModel::class)
interface Address {

    @JsonGetter
    fun email(): String
}
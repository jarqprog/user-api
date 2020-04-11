package com.jarqprog.userapi.writeuser.address

import com.jarqprog.userapi.domain.Address
import java.util.regex.Pattern

class WriteAddress(private val email: String) : Address {

    init {
        validateEmail(email)
    }

    override fun email(): String {
        return email
    }

    private companion object Validation {
        private val emailPattern = Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
            + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
            + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
            + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
            + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
            + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        )

        fun validateEmail(email: String) {
            if (!emailPattern.matcher(email).matches()) throw EmailValidationFailure(email)
        }
    }
}
package com.jarqprog.userwriteapi.address

import java.lang.RuntimeException

class EmailValidationFailure(email: String, message: String = "Email validation failure for value: $email") : RuntimeException(message)
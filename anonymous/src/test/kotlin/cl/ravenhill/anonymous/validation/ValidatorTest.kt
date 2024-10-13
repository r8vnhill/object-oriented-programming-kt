package cl.ravenhill.anonymous.validation

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class ValidatorTest : FreeSpec({
    "A validator" - {
        "when validating an email" - {
            val emailValidator = object : Validator<String> {
                override fun validate(value: String) =
                    value.contains("@") && value.contains(".")
            }
            "should return true if the email is valid" {
                emailValidator.validate("reachme@ravenhill.cl").shouldBeTrue()
            }

            "should return false if the email is invalid" {
                emailValidator.validate("reachme@ravenhill").shouldBeFalse()
            }
        }

        "when validating a password" - {
            val passwordValidator = object : Validator<String> {
                override fun validate(value: String) =
                    value.length >= 8
            }
            "should return true if the password is valid" {
                passwordValidator.validate("password123").shouldBeTrue()
            }

            "should return false if the password is invalid" {
                passwordValidator.validate("pass").shouldBeFalse()
            }
        }
    }
})

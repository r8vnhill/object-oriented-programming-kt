package cl.ravenhill.validation

import cl.ravenhill.matchers.shouldHaveMinimumLength
import cl.ravenhill.users.Username
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.property.Arb
import io.kotest.property.arbitrary.filter
import io.kotest.property.arbitrary.flatMap
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.map
import io.kotest.property.arbs.usernames
import io.kotest.property.checkAll

class HaveMinimumLengthTest : FreeSpec({
    "Given a username" - {
        "when testing if it has a minimum length" - {
            "should pass if the username has the minimum length" {
                checkAll(
                    Arb.int(0..10).flatMap { length ->
                        Arb.usernames()
                            .filter { it.value.length >= length }
                            .map { it.value }
                            .map { length to Username(it) }
                    }
                ) { (length, username) ->
                    username shouldHaveMinimumLength length
                }
            }

            "should fail if the username does not have the minimum length" {
                checkAll(
                    Arb.usernames().flatMap { username ->
                        Arb.int(username.value.length + 1..100)
                            .map { it to Username(username.value) }
                    }
                ) { (length, username) ->
                    shouldThrow<AssertionError> {
                        username shouldHaveMinimumLength length
                    }
                }
            }
        }
    }
})

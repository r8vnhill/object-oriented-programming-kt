package cl.ravenhill.staticfn.users

import cl.ravenhill.matchers.shouldHaveAge
import cl.ravenhill.matchers.shouldHaveName
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.property.Arb
import io.kotest.property.arbitrary.flatMap
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.map
import io.kotest.property.arbs.name
import io.kotest.property.checkAll

class UserTest : FreeSpec({
    "Given a user" - {
        "when creating it with a valid age" - {
            "should be created" {
                checkAll(arbUser(Arb.int(18..200))) { user ->
                    user.shouldHaveName(user.name)
                        .shouldHaveAge(user.age)
                }
            }
        }

        "when creating it with an invalid age" - {
            "should throw an exception" {
                checkAll(Arb.name(), Arb.int(0..17)) { name, age ->
                    shouldThrow<IllegalArgumentException> {
                        User.create(name.toString(), age)
                    }
                }
            }
        }
    }
})

private fun arbUser(ageArb: Arb<Int>): Arb<User> = Arb.name()
    .flatMap { name ->
        ageArb.map { age ->
            User.create(name.toString(), age)
        }
    }

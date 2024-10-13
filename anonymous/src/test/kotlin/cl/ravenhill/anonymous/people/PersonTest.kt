package cl.ravenhill.anonymous.people

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.Gen
import io.kotest.property.arbitrary.map
import io.kotest.property.arbs.name
import io.kotest.property.checkAll

private const val WELCOME_MESSAGE = "Welcome to the team!"

class PersonTest : FreeSpec({
    "A person" - {
        "when greeting" - {
            "should return a greeting according to the person's name" {
                checkAll(arbPerson()) { person ->
                    person.greet() shouldBe
                            "Hello, ${person.name}. $WELCOME_MESSAGE"
                }
            }
        }
    }
})

/**
 * Generates a random `Person` instance for property-based testing.
 *
 * @return A generator of `Person` objects with random names and predefined behavior.
 */
private fun arbPerson(): Gen<Person> = Arb.name()
    .map { name ->
        object : AbstractPerson("$name") {
            override fun someComplexBehavior() =
                WELCOME_MESSAGE
        }
    }

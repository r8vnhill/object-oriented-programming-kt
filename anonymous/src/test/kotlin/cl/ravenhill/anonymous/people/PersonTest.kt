package cl.ravenhill.anonymous.people

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.Gen
import io.kotest.property.arbitrary.map
import io.kotest.property.arbitrary.string
import io.kotest.property.checkAll

class PersonTest : FreeSpec({
    "A person" - {
        "when greeting" - {
            "should return a greeting according to the person's name" {
                checkAll(arbPerson()) { person ->
                    person.greet() shouldBe
                            "Hello, ${person.name}. Welcome to the team!"
                }
            }
        }
    }
})

private fun arbPerson(): Gen<Person> = Arb.string()
    .map { name ->
        object : AbstractPerson(name) {
            override fun someComplexBehavior() =
                "Welcome to the team!"
        }
    }

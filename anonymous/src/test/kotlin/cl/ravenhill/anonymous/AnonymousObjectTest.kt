package cl.ravenhill.anonymous

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class AnonymousObjectTest : FreeSpec({
    "An anonymous object representing a person" - {
        "when greeting" - {
            "should return a greeting according to the person's name" {
                val anonymousObject = object {
                    val name = "Carol Danvers"
                    fun greet() = "Hello, $name"
                }
                anonymousObject.greet() shouldBe "Hello, Carol Danvers"
            }
        }
    }
})

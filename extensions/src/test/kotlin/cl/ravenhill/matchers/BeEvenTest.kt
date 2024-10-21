package cl.ravenhill.matchers

import io.kotest.core.spec.style.FreeSpec
import io.kotest.property.Arb
import io.kotest.property.arbitrary.filter
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.map
import io.kotest.property.arbitrary.negativeInt
import io.kotest.property.checkAll

class BeEvenTest : FreeSpec({
    "A number" - {
        "when testing if it is even and greater or equal to 0" - {
            "should pass if the number is multiple of 2 and non-negative" {
                checkAll(
                    Arb.int(0..1000).map { it * 2 }
                ) { evenNumber ->
                    evenNumber
                        .shouldBeEven()
                        .shouldBePositive()
                }
            }
            "should fail if the number is odd or negative" {
                checkAll(
                    Arb.negativeInt().filter { it % 2 != 0 }
                ) { oddOrNegativeNumber ->
                    oddOrNegativeNumber
                        .shouldNotBeEven()
                        .shouldBeNegative()
                }
            }
        }
    }
})

package cl.ravenhill.complex

import io.kotest.core.spec.style.FreeSpec
import io.kotest.property.Arb
import io.kotest.property.arbitrary.double
import io.kotest.property.arbitrary.map
import io.kotest.property.arbitrary.pair
import io.kotest.property.checkAll

class ComplexTest : FreeSpec({
    "Given a complex number" - {
        "when adding it to another complex number" - {
            "then the real part is the sum of the real parts" {
                checkAll(arbComplex(), arbComplex()) { a, b ->
                    val result = a + b
                    result.real shouldBe (a.real + b.real)
                }
            }

            "then the imaginary part is the sum of the imaginary parts" {
                checkAll(arbComplex(), arbComplex()) { a, b ->
                    val result = a + b
                    result.imaginary shouldBe (a.imaginary + b.imaginary)
                }
            }
        }

        "when adding it to a real number" - {
            "then the real part is the sum of the real parts" {
                checkAll(arbComplex(), Arb.double()) { a, b ->
                    val result = a + b
                    result.real shouldBe (a.real + b)
                }
            }

            "then the imaginary part remains the same" {
                checkAll(arbComplex(), Arb.double()) { a, b ->
                    val result = a + b
                    result.imaginary shouldBe a.imaginary
                }
            }
        }
    }
})

private fun arbComplex() = Arb.pair(Arb.double(), Arb.double())
    .map { (real, imaginary) ->
        Complex(real, imaginary)
    }

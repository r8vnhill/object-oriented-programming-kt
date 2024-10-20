package cl.ravenhill.staticfn.rectangle

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.positiveInt
import io.kotest.property.checkAll

class RectangleAreaTest : FreeSpec({
    "Given a rectangle" - {
        "when calculating its area" - {
            "should return of counting the units" {
                checkAll(
                    Arb.positiveInt(100),
                    Arb.positiveInt(100)
                ) { width, height ->
                    calculateRectangleArea(width, height) shouldBe
                            countAreaOnGrid(width, height)
                }
            }
        }
    }
})

private fun countAreaOnGrid(width: Int, height: Int) = (1..width)
    .sumOf { _ ->
        (1..height).count()
    }.let { "$it cm²" }

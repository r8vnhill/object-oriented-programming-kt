package cl.ravenhill.utils

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.property.Arb
import io.kotest.property.arbitrary.filter
import io.kotest.property.arbitrary.map
import io.kotest.property.arbitrary.string
import io.kotest.property.checkAll

class StringExtensionsTest : FreeSpec({
    "A string" - {
        "when testing if it is a palindrome" - {
            "should return true if the string is equal to its reverse" {
                checkAll(arbPalindrome()) { palindrome ->
                    palindrome.isPalindrome().shouldBeTrue()
                }
            }

            "should return false if the string is not equal to its reverse" {
                checkAll(
                    Arb.string().filter { it != it.reversed() }
                ) { nonPalindrome ->
                    nonPalindrome.isPalindrome().shouldBeFalse()
                }
            }
        }
    }
})

private fun arbPalindrome(): Arb<String> = Arb.string().map {
    it + it.reversed()
}

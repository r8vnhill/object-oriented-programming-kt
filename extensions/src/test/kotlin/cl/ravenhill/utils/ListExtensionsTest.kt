package cl.ravenhill.utils

import io.kotest.core.spec.style.FreeSpec

class ListExtensionsTest : FreeSpec({
    "A list" - {
        "when getting the second element" - {
            "should return the last element if the list has 2 elements" {}
            ("should return the element at index 1 if the list has more than " +
                    "2 elements") {}
            "should throw an exception if the list has less than 2 elements" {}
        }
    }
})

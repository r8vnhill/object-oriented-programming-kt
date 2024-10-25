package cl.ravenhill.matchers

import io.kotest.matchers.Matcher
import io.kotest.matchers.MatcherResult
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNot

fun beNegative() = Matcher<Int> { actual ->
    MatcherResult(
        actual < 0,
        { "Expected $actual to be positive" },
        { "Expected $actual to be negative or zero" }
    )
}

fun Int.shouldBeNegative(): Int {
    this shouldBe beNegative()
    return this
}

fun Int.shouldNotBeNegative(): Int {
    this shouldNot beNegative()
    return this
}

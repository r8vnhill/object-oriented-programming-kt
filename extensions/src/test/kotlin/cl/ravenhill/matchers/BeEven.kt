package cl.ravenhill.matchers

import io.kotest.matchers.Matcher
import io.kotest.matchers.MatcherResult
import io.kotest.matchers.should
import io.kotest.matchers.shouldNot

fun beEven() = Matcher<Int> { actual ->
    MatcherResult(
        actual % 2 == 0,
        { "Expected $actual to be even" },
        { "Expected $actual to be odd" }
    )
}

fun Int.shouldBeEven(): Int {
    this should beEven()
    return this
}

fun Int.shouldNotBeEven(): Int {
    this shouldNot beEven()
    return this
}

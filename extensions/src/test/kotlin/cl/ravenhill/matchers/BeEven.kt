package cl.ravenhill.matchers

import io.kotest.matchers.Matcher
import io.kotest.matchers.MatcherResult

fun beEven() = Matcher<Int> { actual ->
    MatcherResult(
        actual % 2 == 0,
        { "Expected $actual to be even" },
        { "Expected $actual to be odd" }
    )
}

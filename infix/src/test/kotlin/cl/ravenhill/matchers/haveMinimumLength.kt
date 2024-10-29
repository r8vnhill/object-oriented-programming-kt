package cl.ravenhill.matchers

import cl.ravenhill.users.Username
import io.kotest.matchers.Matcher
import io.kotest.matchers.MatcherResult
import io.kotest.matchers.should
import io.kotest.matchers.shouldNot

fun haveMinimumLength(length: Int) = Matcher<Username> { username ->
    MatcherResult(
        username.value.length >= length,
        { "Username should have a minimum length of $length" },
        { "Username should not have a minimum length of $length" }
    )
}

infix fun Username.shouldHaveMinimumLength(length: Int): Username {
    this should haveMinimumLength(length)
    return this
}

infix fun Username.shouldNotHaveMinimumLength(length: Int): Username {
    this shouldNot haveMinimumLength(length)
    return this
}

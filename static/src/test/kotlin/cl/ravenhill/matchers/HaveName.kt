package cl.ravenhill.matchers

import cl.ravenhill.staticfn.users.User
import io.kotest.matchers.Matcher
import io.kotest.matchers.MatcherResult
import io.kotest.matchers.should

fun haveName(name: String) = Matcher<User> { user ->
    MatcherResult(
        user.name == name,
        { "User should have name $name but has ${user.name}" },
        { "User should not have name $name" }
    )
}

fun User.shouldHaveName(name: String): User {
    should(haveName(name))
    return this
}

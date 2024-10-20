package cl.ravenhill.matchers

import cl.ravenhill.staticfn.users.User
import io.kotest.matchers.Matcher
import io.kotest.matchers.MatcherResult
import io.kotest.matchers.should

fun haveAge(age: Int) = Matcher<User> { user ->
    MatcherResult(
        user.age == age,
        { "User should have age $age but has ${user.age}" },
        { "User should not have age $age" }
    )
}

fun User.shouldHaveAge(age: Int): User {
    should(haveAge(age))
    return this
}

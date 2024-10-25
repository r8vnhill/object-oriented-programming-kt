package cl.ravenhill.matchers

class UserName(val value: String)

infix fun UserName.hasMinimumLength(length: Int): Boolean {
    return value.length >= length
}

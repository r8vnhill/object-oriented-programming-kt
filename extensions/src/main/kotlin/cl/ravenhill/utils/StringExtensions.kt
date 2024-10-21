package cl.ravenhill.utils

fun String.isPalindrome(): Boolean {
    for (i in 0..<length / 2) {
        if (this[i] != this[length - i - 1]) {
            return false
        }
    }
    return true
}

package cl.ravenhill.anonymous.validation

interface Validator<T> {
    fun validate(value: T): Boolean
}

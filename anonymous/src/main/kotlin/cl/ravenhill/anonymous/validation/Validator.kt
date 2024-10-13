package cl.ravenhill.anonymous.validation

/**
 * Interface for validating objects of type `T`.
 *
 * This interface is intended to be used with anonymous objects that define specific validation logic. Implementing
 * classes or anonymous objects must provide the `validate` method to define how a given value of type `T` should be
 * validated.
 *
 * ## Usage:
 * The `Validator` interface can be used to create custom validation logic without the need for full class definitions.
 *
 * ### Example 1: Using an Anonymous Object to Validate a String
 * ```kotlin
 * val stringValidator = object : Validator<String> {
 *     override fun validate(value: String): Boolean {
 *         return value.isNotEmpty()
 *     }
 * }
 * println(stringValidator.validate("Hello")) // true
 * println(stringValidator.validate("")) // false
 * ```
 *
 * ### Example 2: Using an Anonymous Object to Validate an Integer
 * ```kotlin
 * val intValidator = object : Validator<Int> {
 *     override fun validate(value: Int): Boolean {
 *         return value > 0
 *     }
 * }
 * println(intValidator.validate(5)) // true
 * println(intValidator.validate(-1)) // false
 * ```
 *
 * @param T The type of value that this validator will check.
 */
interface Validator<T> {
    /**
     * Validates a value of type `T`.
     *
     * @param value The value to be validated.
     * @return `true` if the value is valid, `false` otherwise.
     */
    fun validate(value: T): Boolean
}

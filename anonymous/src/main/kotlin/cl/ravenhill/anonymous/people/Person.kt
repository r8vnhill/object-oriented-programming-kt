package cl.ravenhill.anonymous.people

/**
 * Represents a person with a name and the ability to greet.
 *
 * This interface defines the structure for a `Person`, where each person must have a `name` property and implement the
 * `greet` function, which returns a greeting message.
 *
 * ## Usage:
 * The `Person` interface can be used to define various types of people, each with their own greeting behavior.
 *
 * ### Example 1: Using an Anonymous Object to Implement `Person`
 * ```kotlin
 * val anonymousPerson = object : Person {
 *     override val name = "Serj"
 *     override fun greet() = "Hello, my name is $name"
 * }
 * println(anonymousPerson.greet()) // "Hello, my name is Serj"
 * ```
 *
 * ### Example 2: Using a Class to Implement `Person`
 * ```kotlin
 * class Employee(override val name: String) : Person {
 *     override fun greet() = "Hi, I'm $name and I work here!"
 * }
 * val employee = Employee("Daron")
 * println(employee.greet()) // "Hi, I'm Daron and I work here!"
 * ```
 *
 * @property name The name of the person.
 */
interface Person {
    val name: String

    /**
     * Returns a greeting message.
     *
     * @return A string that greets, incorporating the person's name.
     */
    fun greet(): String
}

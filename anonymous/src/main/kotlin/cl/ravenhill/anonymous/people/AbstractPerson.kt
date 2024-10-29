package cl.ravenhill.anonymous.people

/**
 * A base class representing a person with a customizable greeting message using the Template Pattern.
 *
 * The `AbstractPerson` class implements the [Person] interface and defines the structure of the `greet` method while
 * allowing subclasses to provide custom behavior through the [someComplexBehavior] hook method.
 *
 * The class follows the Template Pattern, where [greet] is the template method that provides a greeting format, and
 * [someComplexBehavior], an abstract method, is the customizable "hook" to be defined by each subclass. This design
 * allows `AbstractPerson` to standardize the greeting structure while delegating specific behavior details to
 * subclasses.
 *
 * ## Usage:
 * Use `AbstractPerson` as a base class to define specific types of persons with custom greeting behavior. Each subclass
 * must implement the `someComplexBehavior` method to define its unique behavior, which will be embedded in the greeting
 * message.
 *
 * ### Example 1: Implementing a Subclass of AbstractPerson
 * ```kotlin
 * class FriendlyPerson(name: String) : AbstractPerson(name) {
 *     override fun someComplexBehavior(): String = "I'm happy to meet you!"
 * }
 *
 * val person = FriendlyPerson("Andy")
 * println(person.greet())  // Outputs: "Hello, Andy. I'm happy to meet you!"
 * ```
 *
 * @property name The name of the person, used in the greeting message.
 * @constructor Initializes the `AbstractPerson` with the provided name.
 */
abstract class AbstractPerson(
    override val name: String
) : Person {

    /**
     * Template method that generates a greeting message with standardized structure and customizable behavior.
     *
     * The `greet` method provides the overall format of the greeting message, combining a basic greeting with
     * additional behavior defined by `someComplexBehavior`, which is implemented by subclasses. This structure
     * illustrates the Template Pattern, where subclasses can modify only specific parts of the message without altering
     * the overall greeting format.
     *
     * @return A greeting string that includes the person's name and the result of `someComplexBehavior`.
     */
    override fun greet() =
        "Hello, $name. ${someComplexBehavior()}"

    /**
     * Abstract method representing customizable behavior in the greeting message.
     *
     * This method acts as a "hook" in the Template Pattern, allowing subclasses to insert unique behavior into the
     * `greet` method. Subclasses must provide an implementation of `someComplexBehavior` to define specific content to
     * be added to the greeting.
     *
     * @return A string representing additional behavior in the greeting.
     */
    protected abstract fun someComplexBehavior(): String
}

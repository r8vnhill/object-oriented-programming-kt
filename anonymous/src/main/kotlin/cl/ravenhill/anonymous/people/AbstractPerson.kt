package cl.ravenhill.anonymous.people

abstract class AbstractPerson(
    override val name: String
) : Person {
    override fun greet() =
        "Hello, $name. ${someComplexBehavior()}"
    protected abstract fun someComplexBehavior(): String
}

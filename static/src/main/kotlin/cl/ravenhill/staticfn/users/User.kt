package cl.ravenhill.staticfn.users

class User private constructor(val name: String, val age: Int) {
    companion object {
        fun create(name: String, age: Int): User {
            require(age >= 18) {
                "Age must be greater than or equal to 18"
            }
            return User(name, age)
        }
    }
}

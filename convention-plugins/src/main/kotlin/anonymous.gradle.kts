import tasks.ModuleSetupTask

tasks.register<ModuleSetupTask>("setupAnonymousModule") {
    description = "Creates the base module and files for the anonymous objects lesson"
    module.set("anonymous")

    doLast {
        createFiles(
            "anonymous",
            test to "AnonymousObjectTest.kt"
        )
        createFiles(
            "validation",
            main to "Validator.kt",
            test to "ValidatorTest.kt"
        )
        createFiles(
            "people",
            main to "Person.kt",
            test to "AbstractPerson.kt",
            test to "PersonTest.kt"
        )
    }
}

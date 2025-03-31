import tasks.ModuleSetupTask

tasks.register<ModuleSetupTask>("setupOperatorOverloadModule") {
    description = "Creates the base module and files for the operator overloading lesson"
    module.set("operator-overload")
    doLast {
        createFiles(
            packageName = "math",
            test to "ComplexTest.kt",
            main to "Complex.kt",
        )
    }
}

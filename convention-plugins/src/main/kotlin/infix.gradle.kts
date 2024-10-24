import tasks.ModuleSetupTask

tasks.register<ModuleSetupTask>("setupInfixModule") {
    description = "Creates the base module and files for the infix functions lesson"
    moduleName.set("infix")

    doLast {
        createFiles(
            packageName = "matchers",
            test to "haveMinimumLength.kt",
        )
        createFiles(
            packageName = "validation",
            test to "ValidationTest.kt",
        )
    }
}

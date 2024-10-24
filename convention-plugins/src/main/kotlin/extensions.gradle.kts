import tasks.ModuleSetupTask

tasks.register<ModuleSetupTask>("setupExtensionsModule") {
    description = "Creates the base module and files for the Data-Driven Testing project"
    moduleName.set("extensions")
    doLast {
        createFiles(
            packageName = "utils",
            main to "StringExtensions.kt",
            test to "StringExtensionsTest.kt",
            main to "ListExtensions.kt",
            test to "ListExtensionsTest.kt",
        )
        createFiles(
            packageName = "connection",
            main to "Host.kt",
            test to "HostTest.kt",
        )
        createFiles(
            packageName = "greet",
            main to "Greeter.kt",
            test to "GreeterTest.kt",
        )
    }
}

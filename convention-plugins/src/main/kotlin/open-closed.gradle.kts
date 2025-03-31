import tasks.ModuleSetupTask

tasks.register<ModuleSetupTask>("setupOpenClosedModule") {
    group = "setup"
    description = "Creates the necessary files for the lesson on open/closed classes."
    module = "open-closed"
    doLast {
        createFiles(
            "database",
            main to "DatabaseConnection.kt",
            main to "EncryptedDatabaseConnection.kt",
        )
    }
}

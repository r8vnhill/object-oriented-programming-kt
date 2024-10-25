import tasks.ModuleSetupTask

tasks.register<ModuleSetupTask>("setupStaticModule") {
    group = "setup"
    description = "Creates the necessary files for the lesson on static members"
    module.set("static")
    doLast {
        createFiles(
            packageName = "geometry",
            main to "RectangleUtils.kt",
            test to "RectangleUtilsTest.kt",
        )
        createFiles(
            packageName = "tasks",
            main to "Task.kt",
            main to "TaskManager.kt",
            test to "TaskManagerTest.kt",
        )
        createFiles(
            packageName = "matchers",
            test to "HaveName.kt",
            test to "HaveAge.kt",
        )
        createFiles(
            packageName = "users",
            main to "User.kt",
            test to "UserTest.kt",
        )
    }
}

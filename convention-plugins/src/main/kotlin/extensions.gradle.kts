val baseName = "extensions"
val baseDir: File = rootProject.file(baseName)
val printError: (String) -> Unit = System.err::println
val (main, test) = listOf("main", "test").map { baseDir.resolve("src/$it/kotlin") }

tasks.register("setupExtensionsModule") {
    group = "setup"
    description = "Creates the base module and files for the extension methods lesson"

    doLast {
        createModule()
        createBuildFile()
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

fun createModule() = when {
    baseDir.exists() -> printError("The base directory already exists")
    baseDir.mkdirs() -> println("The base directory was created successfully")
    else -> printError("The base directory could not be created")
}

fun createBuildFile() = baseDir.resolve("build.gradle.kts").run {
    if (exists()) printError("The build file already exists")
    else writeText("// Intentionally left blank\n")
}

fun createFiles(packageName: String, vararg files: Pair<File, String>) {
    files.forEach { (dir, name) ->
        val group = rootProject.group.toString()
        val packageDir = dir.resolve("$group/$packageName".replace(".", "/"))
        val file = packageDir.resolve(name)
        if (file.exists()) {
            printError("The file $name already exists")
        } else {
            packageDir.mkdirs()
            file.writeText("package $group.$packageName\n\n")
            println("The file $name was created successfully")
        }
    }
}

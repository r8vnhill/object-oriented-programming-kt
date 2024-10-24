val baseDir = "anonymous"
val baseDirFile = rootProject.file(baseDir)

tasks.register("setupAnonymousModule") {
    doLast {
        // Crear el directorio base del módulo y build.gradle.kts si no existe
        baseDirFile.mkdirs()
        createGradleBuild(baseDirFile)
        val main = "main"
        val test = "test"
        val anonymous = "anonymous"

        createFiles(anonymous, test to "AnonymousObjectTest.kt")
        createFiles(
            "$anonymous/validation",
            main to "Validator.kt", test to "ValidatorTest.kt"
        )
        createFiles(
            "$anonymous/people",
            main to "Person.kt", main to "AbstractPerson.kt",
            test to "PersonTest.kt"
        )
    }
}

fun createGradleBuild(baseDir: File) = baseDir.resolve("build.gradle.kts").apply {
    if (!exists()) {
        writeText("// Intentionally left blank")
        println("File created: $this")
    } else {
        println("File already exists: $this")
    }
}

fun createFiles(packageName: String, vararg files: Pair<String, String>) {
    val group = rootProject.group.toString().replace(".", "/")
    files.forEach { (type, fileName) ->
        baseDirFile.resolve(
            "src/$type/kotlin/${group.replace(".", "/")}/$packageName"
        )
            .apply { mkdirs() }
            .resolve(fileName).apply {
                if (!exists()) {
                    writeText("package $group.repo\n\n")
                    println("File created: $this")
                } else {
                    println("File already exists: $this")
                }
            }
    }
}
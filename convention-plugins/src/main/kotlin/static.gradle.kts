val moduleName = "static"
val moduleDir = rootProject.file(moduleName)

tasks.register("setupStaticModule") {
    group = "setup"
    description = "Creates the necessary files for the lesson on static members"

    doFirst {
        val buildName = "build.gradle.kts"
        val printError: (String) -> Unit = System.err::println
        createModuleDirectory(printError)
        createBuildFile(buildName, printError)
    }
}

// Función para crear el directorio del módulo
// Si el directorio ya existe, imprime un mensaje de error; de lo contrario,
// intenta crearlo
fun createModuleDirectory(printError: (String) -> Unit) = moduleDir.run {
    when {
        exists() -> printError("Directory already exists: $absolutePath")
        mkdirs() -> println("Directory created: $absolutePath")
        else -> printError("Failed to create directory: $absolutePath")
    }
}

// Función para crear el archivo 'build.gradle.kts'
// Si el archivo ya existe, imprime un mensaje de error; de lo contrario, lo
// crea con un comentario predeterminado
fun createBuildFile(buildName: String, printError: (String) -> Unit) =
    moduleDir.resolve(buildName).run {
        if (!exists()) {
            writeText("// Intentionally left blank")
            println("File created: $absolutePath")
        } else {
            printError("File already exists: $absolutePath")
        }
    }

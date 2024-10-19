tasks.register("setupAnonymousModule") {
    val baseDir = "anonymous"
    doLast {
        // Crear el directorio base del módulo y build.gradle.kts si no existe
        val operatorOverloadDir = rootProject.file(baseDir).apply { mkdirs() }
        operatorOverloadDir.resolve("build.gradle.kts").apply {
            if (!exists()) {
                writeText("// Intentionally left blank")
                println("File created: $this")
            } else {
                println("File already exists: $this")
            }
        }
    }
}

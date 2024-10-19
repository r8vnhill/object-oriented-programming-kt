tasks.register("setupOperatorOverloadModule") {
    val baseDir = "operator-overload"
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

        // Crear directorios y archivos para Complex.kt y ComplexTest.kt si no existen
        val groupPath = rootProject.group.toString().replace(".", "/")
        listOf("main" to "Complex.kt", "test" to "ComplexTest.kt")
            .forEach { (type, fileName) ->
                val dir = rootProject.file("$baseDir/src/$type/kotlin/$groupPath/complex")
                    .apply { mkdirs() }
                dir.resolve(fileName).apply {
                    if (!exists()) {
                        writeText("package ${rootProject.group}.complex\n\n")
                        println("File created: $this")
                    } else {
                        println("File already exists: $this")
                    }
                }
            }
    }
}

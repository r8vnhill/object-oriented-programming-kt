package tasks

import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.TaskAction
import java.io.File

private val printError: (String) -> Unit = System.err::println

/**
 * A task for setting up a new module in a Gradle project.
 *
 * The `ModuleSetupTask` is an abstract Gradle task designed to create a module directory structure and an initial
 * `build.gradle.kts` file. It provides helper methods to create module-specific source files in the appropriate
 * directories. This task is useful for automating the setup of new modules in a multi-module project.
 *
 * @property moduleName The name of the module to be created. This must be set before executing the task.
 * @property main The directory for the module's main source files (`src/main/kotlin`).
 * @property test The directory for the module's test source files (`src/test/kotlin`).
 */
abstract class ModuleSetupTask : DefaultTask() {

    init {
        group = "setup"
    }

    @get:Input
    abstract val moduleName: Property<String>

    @get:Internal
    val main
        get() = baseDir.resolve("src/main/kotlin")

    @get:Internal
    val test
        get() = baseDir.resolve("src/test/kotlin")

    /**
     * The base directory for the module.
     */
    private val baseDir: File
        get() = project.rootProject.file(moduleName)

    /**
     * Sets up the module by creating the necessary directory and initial build file.
     *
     * If the module directory already exists or cannot be created, an error is printed. Similarly, if the build file
     * already exists, an error is printed.
     */
    @TaskAction
    fun setupModule() {
        createModuleDirectory()
        createBuildFile()
    }

    /**
     * Creates the module directory. Prints an error message if the directory already exists or cannot be created.
     */
    private fun createModuleDirectory() = baseDir.run {
        when {
            exists() -> printError("Directory already exists: $absolutePath")
            mkdirs() -> println("Directory created: $absolutePath")
            else -> printError("Failed to create directory: $absolutePath")
        }
    }

    /**
     * Creates an initial build.gradle.kts file. Prints an error message if the file already exists.
     */
    private fun createBuildFile() = baseDir.resolve("build.gradle.kts").run {
        if (exists()) printError("The build file already exists")
        else writeText("// Intentionally left blank\n")
    }

    /**
     * Creates source files in the specified directories.
     *
     * @param packageName The package name for the files.
     * @param files The directory and file names to create.
     */
    fun createFiles(packageName: String, vararg files: Pair<File, String>) {
        files.forEach { (dir, name) ->
            val group = project.rootProject.group.toString()
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
}

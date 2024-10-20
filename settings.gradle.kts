rootProject.name = "object-oriented-programming-kt"

pluginManagement {
    includeBuild("convention-plugins")
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
    }
}

include(
    ":open-closed",
    ":anonymous",
    ":operator-overload",
    ":static"
)

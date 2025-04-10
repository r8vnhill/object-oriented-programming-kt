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
    ":anonymous",
    ":operator-overload",
    ":static",
    "extensions"
)

include("infix")
include("open-closed")
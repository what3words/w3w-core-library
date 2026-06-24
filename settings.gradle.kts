pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven(url = "https://central.sonatype.com/repository/maven-snapshots/")
    }
    versionCatalogs {
        create("libs") {
            from("com.what3words:android-version-catalog:2026.06.01-SNAPSHOT")

            // Project-specific override: this library still supports API 21,
            // which is lower than the catalog default.
            version("minSdk", "21")
        }
    }
}

rootProject.name = "w3w-core-library"
include(":lib")

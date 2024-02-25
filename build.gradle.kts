plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.library").version("8.1.1").apply(false)
    kotlin("multiplatform").version("1.8.21").apply(false)
    kotlin("plugin.serialization").version("1.9.22").apply(false)
    id("org.jetbrains.dokka").version("1.9.10").apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

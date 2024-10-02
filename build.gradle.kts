plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.jetbrains.dokka) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.version.catalog.update)
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlinSerialization) apply false
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.compose.compiler) apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

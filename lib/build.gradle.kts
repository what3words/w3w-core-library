import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("maven-publish")
    id("signing")
    alias(libs.plugins.jetbrains.dokka)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.vanniktech.mavenPublish)
}

kotlin {
    jvm()
    androidTarget {
        publishLibraryVariants("release")
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kotlinx.coroutines.core)
                implementation(compose.runtime)
                implementation(compose.foundation)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.kotlinx.coroutines.test)
            }
        }
    }
}

android {
    namespace = "com.what3words.core"
    compileSdk = libs.versions.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

mavenPublishing {
    publishToMavenCentral()

    signAllPublications()

    coordinates(libs.versions.groupId.get(), libs.versions.artifactId.get())

    pom {
        name = "what3words core library"
        description = "Multiplatform library for what3words domain classes and interfaces."
        inceptionYear = "2024"
        url = "https://github.com/what3words/w3w-core-library"
        licenses {
            license {
                name = "MIT License"
                url = "https://github.com/what3words/w3w-core-library/blob/master/LICENSE"
                distribution = "https://www.opensource.org/licenses/mit-license.php"
            }
        }
        developers {
            developer {
                id = "what3words"
                name = "what3words"
                url = "development@what3words.com"
            }
        }
        scm {
            url = "https://github.com/what3words/w3w-core-library/tree/master"
            connection = "scm:git:git://github.com/what3words/w3w-core-library.git"
            developerConnection = "scm:git:ssh://git@github.com:what3words/w3w-core-library.git"
        }
    }
}
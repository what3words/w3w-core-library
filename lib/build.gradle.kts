import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("maven-publish")
    id("signing")
    alias(libs.plugins.dokka)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.multiplatform.library)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.vanniktech.maven.publish)
}

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }

    jvm()

    android {
        namespace = "com.what3words.core"
        compileSdk = libs.versions.compileSdk.get().toInt()
        minSdk = libs.versions.minSdk.get().toInt()
        compilerOptions {
            jvmTarget.set(JvmTarget.fromTarget(libs.versions.jvmToolchain.get()))
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
                implementation(libs.compose.runtime)
                implementation(libs.compose.foundation)
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

mavenPublishing {
    publishToMavenCentral()

    signAllPublications()

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

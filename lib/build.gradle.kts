import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework
import java.net.URI

plugins {
    id("maven-publish")
    id("signing")
    alias(libs.plugins.jetbrains.dokka)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

group = "com.what3words"

/**
 * IS_SNAPSHOT_RELEASE property will be automatically added to the root gradle.properties file by the CI pipeline, depending on the GitHub branch.
 * A snapshot release is generated for every pull request merged or commit made into an epic branch.
 */
val isSnapshotRelease = findProperty("IS_SNAPSHOT_RELEASE") == "true"

version =
    if (isSnapshotRelease) "${findProperty("VERSION_NAME")}-SNAPSHOT" else "${findProperty("VERSION_NAME")}"

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    applyDefaultHierarchyTemplate()
    compilerOptions {
        androidTarget {
            compilerOptions.jvmTarget.set(JvmTarget.JVM_1_8)
        }
    }
    jvm {
        mavenPublication {
            artifactId = "w3w-core-jvm"
        }
    }
    androidTarget {
        mavenPublication {
            artifactId = "w3w-core-android"
        }
        publishLibraryVariants("release", "debug")
    }
    val xcFramework = XCFramework("W3WCore")
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "W3WCore"
            xcFramework.add(this)
        }
    }

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
}

val ossrhUsername = findProperty("OSSRH_USERNAME") as String?
val ossrhPassword = findProperty("OSSRH_PASSWORD") as String?
val signingKey = findProperty("SIGNING_KEY") as String?
val signingKeyPwd = findProperty("SIGNING_KEY_PWD") as String?
dependencies {
    implementation(libs.ui.graphics.android)
}


afterEvaluate {
    publishing {
        repositories {
            publications {
                withType(MavenPublication::class.java) {
                    if (name.contains("kotlinMultiplatform", ignoreCase = true)) {
                        artifactId = "w3w-core-multiplatform"
                    }
                    val publicationName = name
                    val dokkaJar =
                        project.tasks.register("${publicationName}DokkaJar", Jar::class) {
                            group = JavaBasePlugin.DOCUMENTATION_GROUP
                            description = "Assembles Kotlin docs with Dokka into a Javadoc jar"
                            archiveClassifier.set("javadoc")
                            from(tasks.named("dokkaHtml"))

                            // Each archive name should be distinct, to avoid implicit dependency issues.
                            // We use the same format as the sources Jar tasks.
                            // https://youtrack.jetbrains.com/issue/KT-46466
                            archiveBaseName.set("${archiveBaseName.get()}-$publicationName")
                        }
                    artifact(dokkaJar)
                    pom {
                        name.set("w3w-core-library")
                        description.set("Multiplatform library for what3words domain classes and interfaces.")
                        url.set("https://github.com/what3words/w3w-core-library")
                        licenses {
                            license {
                                name.set("The MIT License (MIT)")
                                url.set("https://github.com/what3words/w3w-core-library/blob/master/LICENSE")
                            }
                        }
                        developers {
                            developer {
                                id.set("what3words")
                                name.set("what3words")
                                email.set("development@what3words.com")
                            }
                        }
                        scm {
                            connection.set("scm:git:git://github.com/what3words/w3w-core-library.git")
                            developerConnection.set("scm:git:ssh://git@github.com:what3words/w3w-core-library.git")
                            url.set("https://github.com/what3words/w3w-core-library/tree/master")
                        }
                    }
                }
            }
            maven {
                name = "sonatype"
                val releasesRepoUrl =
                    "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
                val snapshotsRepoUrl =
                    "https://s01.oss.sonatype.org/content/repositories/snapshots/"
                url = if (version.toString()
                        .endsWith("SNAPSHOT")
                ) URI.create(snapshotsRepoUrl) else URI.create(releasesRepoUrl)

                credentials {
                    username = ossrhUsername
                    password = ossrhPassword
                }
            }
        }
    }
}

signing {
    useInMemoryPgpKeys(signingKey, signingKeyPwd)
    sign(publishing.publications)
}
// build.gradle.kts

// Configure Gradle wrapper.
tasks.withType<Wrapper> {
    // Specify Gradle version for the wrapper.
    gradleVersion = "5.4.1"
}

// Use Kotlin DSL feature available in latest Gradle versions.
// https://docs.gradle.org/current/userguide/kotlin_dsl.html
plugins {
    // Building and application.
    application
    // Building a Kotlin application to run on JVM.
    kotlin("jvm") version "1.3.40"
}

// Configure application plugin.
application {
    // See @file:JvmName("Client") in src/main/kotlin/Client.kt
    mainClassName = "client.Client"
}

// Repositories to pull dependencies from.
repositories {
    mavenCentral() // To get Kotlin dependencies.
    jcenter() // To pull TeamCity REST client dependency.
}

// Configure dependencies.
dependencies {
    // Add TeamCity REST client dependency, version 1.7.26.
    compile("org.jetbrains.teamcity:teamcity-rest-client:1.7.26")
}

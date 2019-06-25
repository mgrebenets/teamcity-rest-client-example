// Client.kt

// Default JVM name for this file will be "ClientKt".
// Tell JVM that I want it to be called just "Client".
@file:JvmName("Client")

// Name of the application package.
package client

import kotlin.system.exitProcess
// Import TeamCity REST client package.
import org.jetbrains.teamcity.rest.*

// Main entry point to my application.
fun main(args: Array<String>) {
    // Expect TeamCity URL, username, password and bbuild configuration identifier
    // provided as input arguments.
    if (args.count() < 4) {
        println("Usage: client TEAMCITY_URL USERNAME PASSWORD BUILD_ID")
        exitProcess(1)
    }

    // Authenticate and connect to TeamCity instance.
    val tc = TeamCityInstanceFactory.httpAuth(args[0], args[1], args[2])

    // Create build configuration identifier instance.
    val id = BuildConfigurationId(args[3])

    val build = tc.builds() // Get builds visible to the user.
        .fromConfiguration(id) // Get builds from build configuration with the specified identifier.
        .latest() // Get latest build information.

    println(build) // Print build information to stdout.
}
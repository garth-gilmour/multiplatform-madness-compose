import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("org.jetbrains.compose")
}

group "compose.web"
version "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    js(IR) {
        browser {
            testTask {
                testLogging.showStandardStreams = true
                useKarma {
                    useChromeHeadless()
                    useFirefox()
                }
            }
        }
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(compose.runtime)
                implementation("io.ktor:ktor-client-js:${extra["ktor.version"]}")
                implementation("io.ktor:ktor-client-core:${extra["ktor.version"]}")
                implementation("io.ktor:ktor-client-content-negotiation:${extra["ktor.version"]}")
                implementation("io.ktor:ktor-serialization-kotlinx-json:${extra["ktor.version"]}")
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
                implementation(compose.web.testUtils)
            }
        }
    }
}
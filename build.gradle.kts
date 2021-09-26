import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val ktor_version = "1.6.1"

plugins {
    kotlin("js") version "1.5.10"
    kotlin("plugin.serialization") version "1.5.31"
}

group = "me.jonnalves"
version = "1.0-SNAPSHOT"

repositories {
    maven(url = "https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.5.21")
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.3")
    implementation("io.ktor:ktor-client-js:$ktor_version")
    implementation("io.ktor:ktor-client-logging:$ktor_version")
    implementation("io.ktor:ktor-client-serialization:$ktor_version")
    implementation(kotlin("stdlib-jdk8"))
}


kotlin {
    js(IR) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
}

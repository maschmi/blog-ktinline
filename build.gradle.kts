plugins {
    kotlin("jvm") version "1.9.22"
    id("me.champeau.jmh") version "0.7.2"
}

group = "de.maschmi.blog"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("org.openjdk.jmh:jmh-core:1.36")
    implementation("org.openjdk.jmh:jmh-generator-annprocess:1.36")
    jmh("org.openjdk.jmh:jmh-core:1.36")
    jmh("org.openjdk.jmh:jmh-generator-annprocess:1.36")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
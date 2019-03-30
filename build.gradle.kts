import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.21"
}

repositories { jcenter() }

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    api("com.graphql-java:graphql-java:12.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        apiVersion = "1.3"
        languageVersion = "1.3"
        jvmTarget = "1.8"
    }
}

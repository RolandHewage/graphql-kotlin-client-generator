import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.expediagroup.graphql.plugin.gradle.graphql

plugins {
    kotlin("jvm") version "1.5.10"
    id("com.expediagroup.graphql") version "5.1.0"
    application
}

application {
    mainClass.set("demo.AppKt")
}

group = "me.roland"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.expediagroup:graphql-kotlin-spring-client:5.1.0")
    implementation("com.expediagroup:graphql-kotlin-ktor-client:5.1.0")
    implementation("io.ktor:ktor-client-okhttp:1.6.4")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

graphql {
    client {
        endpoint = "https://countries.trevorblades.com"
        packageName = "com.example.generated"
    }
}

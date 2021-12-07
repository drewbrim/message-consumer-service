import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.1"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    kotlin("jvm") version "1.4.21"
    kotlin("plugin.spring") version "1.4.21"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")

    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")

    implementation("org.springframework.cloud:spring-cloud-stream:3.1.5")
    implementation("org.springframework.cloud:spring-cloud-starter-stream-kafka:3.1.5")
    implementation("org.springframework.kafka:spring-kafka:2.7.6")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
    implementation("com.google.code.gson:gson:2.8.5")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.apache.kafka:kafka-clients:2.8.1")
    implementation("org.springframework.kafka:spring-kafka:2.7.6")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.6")
    testImplementation("org.springframework.kafka:spring-kafka-test:2.7.6")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

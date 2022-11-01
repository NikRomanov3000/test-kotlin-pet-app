import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.4"
    id("io.spring.dependency-management") version "1.0.14.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
    checkstyle
}

checkstyle {
    config = rootProject.resources.text.fromFile("/config/checkstyle/checkstyle.xml")
    reportsDir = file("${buildDir}/report")
    toolVersion = "10.4"
    isIgnoreFailures = false
    maxWarnings = 0
    maxErrors = 0
}

group = "ru.rsu"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.22")
    implementation("io.springfox:springfox-boot-starter:3.0.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.liquibase:liquibase-core")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Checkstyle>().configureEach {
    source = fileTree("src/main")
    reports {
        xml.required.set(false)
        html.required.set(true)
        html.stylesheet = resources.text.fromFile("config/xsl/checkstyle-simple.xsl")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

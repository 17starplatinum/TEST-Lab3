plugins {
    id("java")
}

group = "ru.itmo.cs.kdot.lab3"
version = "1.0-SNAPSHOT"
var seleniumVersion = "4.29.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.seleniumhq.selenium:selenium-java:${seleniumVersion}")
    implementation("org.seleniumhq.selenium:selenium-chrome-driver:${seleniumVersion}")
    implementation("org.seleniumhq.selenium:selenium-firefox-driver:${seleniumVersion}")
    implementation("org.seleniumhq.selenium:selenium-safari-driver:${seleniumVersion}")
    implementation("org.seleniumhq.selenium:selenium-edge-driver:${seleniumVersion}")
    implementation("org.seleniumhq.selenium:selenium-opera-driver:${seleniumVersion}")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
plugins {
    id("java")
}

group = "ru.itmo.cs.kdot.lab3"
version = "1.0-SNAPSHOT"

var seleniumVersion = "4.31.0"
var lombokVersion = "1.18.38"
val allureVersion = "2.25.0"
val aspectJVersion = "1.9.21"

val agent: Configuration by configurations.creating {
    isCanBeConsumed = true
    isCanBeResolved = true
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.seleniumhq.selenium:selenium-java:${seleniumVersion}")
    implementation("org.seleniumhq.selenium:selenium-chrome-driver:${seleniumVersion}")

    // Для расширяемости, мне важно показывать, работает ли эта штуковина или нет
//    implementation("org.seleniumhq.selenium:selenium-firefox-driver:${seleniumVersion}")
//    implementation("org.seleniumhq.selenium:selenium-safari-driver:${seleniumVersion}")
//    implementation("org.seleniumhq.selenium:selenium-edge-driver:${seleniumVersion}")
//    implementation("org.seleniumhq.selenium:selenium-opera-driver:${seleniumVersion}")
    implementation("org.projectlombok:lombok:${lombokVersion}")
    annotationProcessor("org.projectlombok:lombok:${lombokVersion}")
    testImplementation("org.projectlombok:lombok:${lombokVersion}")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation(platform("io.qameta.allure:allure-bom:$allureVersion"))
    testImplementation("io.qameta.allure:allure-junit5")
    agent("org.aspectj:aspectjweaver:${aspectJVersion}")
}

tasks.test {
    useJUnitPlatform()
    jvmArgs = listOf(
        "-javaagent:${agent.singleFile}"
    )
}
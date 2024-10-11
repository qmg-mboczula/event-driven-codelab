plugins {
    id("java")
}

group = "com.qmetric"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":payment-service"))
    implementation(project(":message-broker"))
    implementation(project(":notification-service"))
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
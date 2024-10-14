plugins {
    id("java")
}

group = "com.qmetric"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":message-broker"))
    implementation(project(":shared"))
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
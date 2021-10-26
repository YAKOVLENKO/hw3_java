plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.inject:guice:4.0")
    implementation("com.google.code.gson:gson:2.8.8")
    implementation("com.intellij:annotations:12.0")
    compileOnly(group = "org.projectlombok", name = "lombok", version = "1.18.22")
    annotationProcessor(group = "org.projectlombok", name = "lombok", version = "1.18.22")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
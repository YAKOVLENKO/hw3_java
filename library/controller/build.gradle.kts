plugins {
    java
    application
}

application {
    mainClassName = "Application"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {

    implementation("com.google.inject:guice:4.0")
    implementation(project(":models"))
    implementation("com.intellij:annotations:12.0")
    compileOnly(group = "org.projectlombok", name = "lombok", version = "1.18.22")
    annotationProcessor(group = "org.projectlombok", name = "lombok", version = "1.18.22")

    testImplementation("com.google.inject:guice:4.0")
    testImplementation("com.github.marcolamberto:guice-junit-runner:master-SNAPSHOT")
//    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
//    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("junit:junit:4.13")
    testImplementation("org.mockito:mockito-core:3.+")
    testImplementation("org.mockito:mockito-core:4.0.0")
    testImplementation("org.hamcrest:hamcrest-all:1.3")


}

tasks.test {
    useJUnit()

    maxHeapSize = "1G"
}
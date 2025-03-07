plugins {
    `java-library`
    jacoco
}

repositories {
    mavenCentral()
}

dependencies {
    // ✅ Ensure JUnit 5 (Jupiter) is included correctly
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

// ✅ Ensure Gradle uses JUnit 5
tasks.named<Test>("test") {
    useJUnitPlatform()
}

// ✅ Ensure JaCoCo tracks all compiled classes
tasks.named<JacocoReport>("jacocoTestReport") {
    dependsOn("test")

    reports {
        xml.required.set(true)
        html.required.set(true)
    }

    classDirectories.setFrom(
        fileTree(layout.buildDirectory.dir("classes/java/main")) {
            exclude("org/example/**") // Exclude Gradle's default template files
        }
    )

    sourceDirectories.setFrom(files("src/main/java"))
}

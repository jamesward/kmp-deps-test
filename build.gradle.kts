plugins {
    application
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

application {
    mainClass.set("Main")
}

dependencies {
    implementation("com.squareup.okio:okio:3.0.0")
}

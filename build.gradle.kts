plugins {
    application
}

repositories {
    mavenLocal()
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
    implementation("com.jamesward:kmp-lib-test:0.0.1")
}

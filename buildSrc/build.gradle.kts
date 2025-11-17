plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    mavenLocal()
    google()
    gradlePluginPortal()
}

dependencies {
    implementation(libs.kotlinGradle)
    implementation(libs.androidGradle)
    implementation(libs.spotlessGradle)
    implementation(libs.kspGradle)
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

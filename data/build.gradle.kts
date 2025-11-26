import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("multiplatform")
    alias(libs.plugins.kotlin.serialization)
    id("template.android-lib")
    id("template.ksp-targets")
    id("template.koin")
    id("template.room")
    id("compiler-args")
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        androidMain.dependencies {
            implementation(libs.ktor.android)
        }
        commonMain.dependencies {
            implementation(projects.domain)

            implementation(project.dependencies.platform(libs.ktor.bom))
            implementation(libs.ktor.core)
            implementation(libs.ktor.serializationJson)
            implementation(libs.ktor.contentNegotiation)
            implementation(libs.ktor.logging)
            implementation(libs.ktor.resources)
            implementation(libs.androidx.roomRuntime)
        }
        iosMain.dependencies {
            implementation(libs.ktor.ios)
        }
    }

    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {
        // Common compiler options applied to all Kotlin source sets
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }
}

android {
    namespace = "nl.klrnbk.daan.half_a_minute.data"
}

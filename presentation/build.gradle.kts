import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("multiplatform")
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.jetbrains.composeCompiler)
    id("template.android-app")
    id("template.ksp-common")
    id("template.koin")
    id("compiler-args")
}

// TODO: this can be removed when Koin uses the KMP viewmodel import instead of Android
// https://github.com/InsertKoinIO/koin-annotations/issues/130
// https://github.com/InsertKoinIO/koin-annotations/pull/133
ksp {
    arg("USE_COMPOSE_VIEWMODEL", "true")
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Presentation"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.compose.ui.toolingPreview)
            implementation(libs.compose.ui.tooling)
            implementation(libs.androidx.activityCompose)
            implementation(libs.androidx.coreSplash)
            implementation(libs.androidx.appcompat)
        }
        commonMain.dependencies {
            implementation(projects.domain)
            implementation(projects.data)

            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

            implementation(libs.androidx.navigationCompose)
            implementation(libs.androidx.lifecycleViewmodel)

            implementation(libs.koin.compose)
            implementation(libs.koin.composeViewmodel)

            implementation(libs.coil)
            implementation(libs.coil.core)
            implementation(libs.coil.composeCore)
            implementation(libs.coil.network)
        }

        iosMain.dependencies {
            implementation(libs.snizzors)
        }
    }
}

android {
    namespace = "nl.klrnbk.daan.half_a_minute"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig.applicationId = "nl.klrnbk.daan.half_a_minute"

    buildFeatures {
        compose = true
    }
}

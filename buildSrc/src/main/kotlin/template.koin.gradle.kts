import gradle.kotlin.dsl.accessors._0f2de5e27de39b5518fc15a55d9768e9.ksp

plugins {
    kotlin("multiplatform")
}

ksp {
    arg("KOIN_DEFAULT_MODULE","false")
}

kotlin {
    sourceSets.commonMain.dependencies {
        implementation(libs.koin.core)
        api(libs.koin.annotations)
    }
}
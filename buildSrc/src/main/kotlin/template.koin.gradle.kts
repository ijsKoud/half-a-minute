import gradle.kotlin.dsl.accessors._03443ba5827570f5200fc5a097e36519.ksp

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
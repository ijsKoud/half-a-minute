plugins {
    kotlin("multiplatform")
    id("com.google.devtools.ksp")
}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets.commonMain.dependencies {
        implementation(libs.androidx.roomRuntime)
        implementation(libs.androidx.sqliteBundled)
    }
}

dependencies {
    add("kspAndroid", libs.androidx.roomCompiler)
    add("kspIosSimulatorArm64", libs.androidx.roomCompiler)
    add("kspIosX64", libs.androidx.roomCompiler)
    add("kspIosArm64", libs.androidx.roomCompiler)
}

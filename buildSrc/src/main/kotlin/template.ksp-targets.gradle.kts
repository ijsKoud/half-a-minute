plugins {
    kotlin("multiplatform")
    id("com.google.devtools.ksp")
}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
}

dependencies {
    add("kspAndroid", libs.koin.kspCompiler)
    add("kspIosSimulatorArm64", libs.koin.kspCompiler)
    add("kspIosX64", libs.koin.kspCompiler)
    add("kspIosArm64", libs.koin.kspCompiler)
}
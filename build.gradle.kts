plugins {
    id("template.spotless")
    alias(libs.plugins.jetbrains.compose) apply false
    alias(libs.plugins.jetbrains.composeCompiler) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    id("template.ksp-common") apply false
    id("template.ksp-targets") apply false
}

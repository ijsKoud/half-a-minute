plugins {
    id("com.diffplug.spotless")
}

extensions.configure<com.diffplug.gradle.spotless.SpotlessExtension> {
    kotlin {
        target("**/*.kt")
        targetExclude("**/build/**/*.kt")
        ktlint()
    }
    kotlinGradle {
        target("**/*.gradle.kts")
        targetExclude("caches/**", "wrapper/**", "buildSrc/**")
        ktlint()
    }
    format("kts") {
        target("**/*.kts")
        targetExclude("**/build/**/*.kts")
    }
    format("misc") {
        target("**/*.md", "**/.gitignore")
        targetExclude("caches/**", "wrapper/**", "editorconfig")
        indentWithSpaces()
        trimTrailingWhitespace()
        endWithNewline()
    }
}

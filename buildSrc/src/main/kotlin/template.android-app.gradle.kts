plugins {
    id("com.android.application")
}

android {
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    signingConfigs {
        create("default") {
            storeFile = file(project.findProperty("key_store_path").toString())
            keyAlias = project.findProperty("key_store_alias").toString()
            storePassword = project.findProperty("key_store_password").toString()
            keyPassword = project.findProperty("alias_password").toString()
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isDefault = true
            isMinifyEnabled = false
            enableUnitTestCoverage = true
            applicationIdSuffix = ".dev"
            signingConfig = signingConfigs.getByName("debug")
        }
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("debug")
            proguardFiles(getDefaultProguardFile("proguard-android.txt"))
        }
    }
    applicationVariants.forEach { variant ->
        variant.resValue("string", "package_name", variant.applicationId)
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}

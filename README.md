# Introduction
Compose Multiplatform template app targeting Android and iOS.

# Renaming template
Use this gradle command to rename the project, it will rename the packages and imports and applicationId and namespaces:

``` shell
./gradlew renameTemplate -PnewProjectId=<com.example.project>
```

You can remove this task from the root `build.gradle.kts` after this has been completed. 

# Features
- Example (non-functional) setup of connecting to an API (you have to add your own url's and handle JSON accordingly)
- Example setup of having logic in the data layer separated using expect and actual implementations.
- Simple composable for displaying a message (PlatformMessage) coming from one of the platforms.
- Custom theming for multiplatform

# Pre-requirements
- do { Use a MAC (or ask for one) } while (you.laptop.os == Windows)
- XCode Command line tools (comes free with installing XCode)
- Kotlin Multiplatform plugin (made by Jetbrains) from the plugin store in Android Studio

# How to run
- Use a compatible Android Studio version which is compatible with the Android Gradle plugin 8.2.2 (Koala for example)
- Sync the project
- Build the project (there is a known error with koin, no fix at the moment but is not blocking for running the app)
- For Android pick presentation configuration
- For iOS pick iosApp configuration (available if you've installed the Kotlin Multiplatform plugin)
- Run (for iOS emulator should start automatically, no need to open XCode)

# Known issues
- Koin uses ksp to generate code. The generated code has an exception. As long as App.kt Composable can perform the following line:
  AppModule().module.
  There should be no problem to run the project even this exception is thrown during build time. If that does not work try gradlew clean and comment out the AppModule entirely.
  Project will fail on next run then re-add the AppModule and build again. This time the generated code for AppModule should allow for calling AppModule().module.

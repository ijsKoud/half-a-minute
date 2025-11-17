import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.the

internal val Project.libs: LibrariesForLibs
    get() = the<LibrariesForLibs>()

internal fun DependencyHandlerScope.implementation(dependency: Provider<MinimalExternalModuleDependency>) {
    add("implementation", dependency.get())
}

internal fun DependencyHandlerScope.kapt(dependency: Provider<MinimalExternalModuleDependency>) {
    add("kapt", dependency.get())
}

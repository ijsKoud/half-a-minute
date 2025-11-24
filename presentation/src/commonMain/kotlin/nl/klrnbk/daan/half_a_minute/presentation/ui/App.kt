package nl.klrnbk.daan.half_a_minute.presentation.ui

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import nl.klrnbk.daan.half_a_minute.data.context.ContextWrapper
import nl.klrnbk.daan.half_a_minute.data.di.contextModule
import nl.klrnbk.daan.half_a_minute.presentation.constants.getTabBarEntries
import nl.klrnbk.daan.half_a_minute.presentation.di.AppModule
import nl.klrnbk.daan.half_a_minute.presentation.navigation.LandingRoute
import nl.klrnbk.daan.half_a_minute.presentation.navigation.landingScreen
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.TabBar
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.navigation.PageNavigation
import org.koin.compose.KoinApplication
import org.koin.ksp.generated.module

@Composable
fun App(
    contextWrapper: ContextWrapper,
    navController: NavHostController = rememberNavController(),
) = KoinApplication(
    application = {
        modules(
            AppModule().module,
            contextModule(contextWrapper),
        )
    },
) {
    AppTheme {
        Surface(
            color = AppTheme.colors.primary,
            modifier = Modifier.fillMaxSize(),
        ) {
            Scaffold(
                bottomBar = { PageNavigation(navController = navController) },
                containerColor = AppTheme.colors.primary
            ) {
                NavHost(
                modifier = Modifier.windowInsetsPadding(WindowInsets.systemBars),
                    navController = navController,
                    startDestination = LandingRoute,
                ) {
                    landingScreen()
                }
            }
        }
    }
}

package nl.klrnbk.daan.half_a_minute.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension
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
        Scaffold(
            bottomBar = { PageNavigation(navController = navController) },
            containerColor = AppTheme.colors.primary,
            modifier = Modifier.fillMaxSize()
        ) { paddingValues ->
            Column(
                modifier = Modifier.fillMaxSize().padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Surface(
                    color = AppTheme.colors.primary,
                    modifier = Modifier
                        .padding(horizontal = Dimension.Padding.large)
                        .wrapContentWidth()
                        .sizeIn(maxWidth = 512.dp),
                ) {
                    NavHost(
                        modifier = Modifier
                            .windowInsetsPadding(WindowInsets.systemBars),
                        navController = navController,
                        startDestination = LandingRoute,
                    ) {
                        landingScreen()
                    }
                }
            }
        }
    }
}

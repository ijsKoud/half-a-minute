package nl.klrnbk.daan.half_a_minute.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.landing.LandingScreen

const val LandingRoute = "/"

fun NavController.navigateToLanding() {
    this.navigate(route = LandingRoute)
}

fun NavGraphBuilder.landingScreen(navController: NavController) {
    composable(
        route = LandingRoute
    ) {
        LandingScreen(
            navigateToCreateGame = navController::navigateToCreateGame
        )
    }
}

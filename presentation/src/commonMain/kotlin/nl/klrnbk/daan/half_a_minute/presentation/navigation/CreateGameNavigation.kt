package nl.klrnbk.daan.half_a_minute.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.create.CreateGameScreen
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.landing.LandingScreen

const val CreateGameRoute = "/create"

fun NavController.navigateToCreateGame() {
    this.navigate(route = CreateGameRoute)
}

fun NavGraphBuilder.createGameScreen(navController: NavController) {
    composable(
        route = CreateGameRoute
    ) {
        CreateGameScreen(
            navigateToLanding = navController::navigateToLanding,
            navigateToGameInvite = navController::navigateToGameInvite
        )
    }
}

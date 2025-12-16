package nl.klrnbk.daan.half_a_minute.presentation.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.overview.GameOverviewScreen

private const val GameIdArg = "gameId"

const val GameOverviewRoute = "/game/{$GameIdArg}/overview"

internal class GameOverviewArgs(val gameId: Uuid) {
    constructor(savedStateHandle: SavedStateHandle) :
        this(gameId = Uuid.parse(checkNotNull(savedStateHandle[GameIdArg])))
}

fun NavController.navigateToGameOverview(gameId: Uuid) {
    this.navigate(route = GameOverviewRoute.replace("{$GameIdArg}", gameId.toString()))
}

fun NavGraphBuilder.gameOverviewScreen(navController: NavController) {
    composable(
        route = GameOverviewRoute
    ) {
        val args = GameOverviewArgs(it.savedStateHandle)
        GameOverviewScreen(
            gameId = args.gameId,
            navigateBack = navController::popBackStack,
            navigateToTeamSelection = navController::navigateToIndividualTeamSelection
        )
    }
}
